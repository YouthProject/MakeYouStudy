package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.usage.NetworkStats;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.tlaabs.timetableview.TimetableView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DiaryActivity extends AppCompatActivity {

    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static ArrayList<Diary> data;
    public static DiaryDBHelper dbHelper;
    public static DiaryPassDBHelper pdbHelper;
    public static SQLiteDatabase db;


    public static EditText edit_title, edit_contents;
    public static Button save_btn;

    public static Button refresh_btn;
    public static ListView list_diary;
    public static DiaryListAdapter listAdapter;

    public static Switch secretSwitch;
    public static EditText secretEditText;
    public static Button secretSaveBtn;

    public static EditText checkPass;
    public static int flag = 0;
    public static int flag2 = 0;
    //firebase auth object
    private FirebaseAuth firebaseAuth;


    //파이어베이스
    private DatabaseReference mDatabaseReference;
    private static FirebaseDatabase mFirebaseDatabase;

    //view objects
    private TextView textViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        //oncreate 속 파이어베이스선언
        textViewUserEmail = (TextView)findViewById(R.id.textviewUserEmail);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
        //---------여기까지


        dbHelper = new DiaryDBHelper(this);
        pdbHelper = new DiaryPassDBHelper(this);
        data = new ArrayList<>();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_settings_white_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_create_white_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_visibility_white_48dp));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Tab_pager_Adapter pagerAdapter = new Tab_pager_Adapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void load(String value) {
    }

    //다이어리 작성 내부 클라스
    public static class Diary_Write extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tab_write, container, false);
            edit_title = (EditText) view.findViewById(R.id.edit_title_write);
            edit_contents = (EditText) view.findViewById(R.id.edit_contents_write);
            save_btn = (Button) view.findViewById(R.id.save_btn_write);
            save_btn.setOnClickListener(new View.OnClickListener() {
                public DatabaseReference mFirebaseDatabase;

                @Override
                public void onClick(View v) {
                    InsertDB();
                }
            });
            return view;
        }
    }

    //다이어리 리스트 내부 클래스
    public static class Diary_List extends Fragment{

        @Nullable
        @Override
        public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.tab_list, container, false);
            flag = 1;
            refresh_btn = (Button) view.findViewById(R.id.refresh_btn_list);
            refresh_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(secretSwitch.isChecked()){
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                        alertDialog.setMessage("비밀번호를 입력하세요");
                        View dialogview = inflater.inflate(R.layout.passwd, container, false);
                        alertDialog.setView(dialogview);
                        checkPass = (EditText)dialogview.findViewById(R.id.check_pass);

                        alertDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String cp = checkPass();
                                if(checkPass.getText().toString().equals(cp)){
                                    list_diary = (ListView) view.findViewById(R.id.list_diary);
                                    data = showDB();
                                    listAdapter = new DiaryListAdapter(getContext(), R.layout.list_layout, data);
                                    list_diary.setAdapter(listAdapter);
                                    list_diary.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            Intent intent = new Intent(getContext(), Diary_Update.class);
                                            int code = data.get(position).getCode();
                                            intent.putExtra("code", code);
                                            startActivity(intent);
                                        }
                                    });
                                    list_diary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                        @Override
                                        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                                            alertDialog.setMessage(data.get(position).getTitle()+"을(를) 삭제하시겠습니까?");
                                            alertDialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    int code = data.get(position).getCode();
                                                    deleteDB(code);
                                                    showDB();
                                                    listAdapter.notifyDataSetChanged();
                                                }
                                            });
                                            alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                }
                                            });
                                            alertDialog.show();
                                            return false;
                                        }
                                    });
                                }else{
                                    Toast.makeText(getContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                                    list_diary = (ListView) view.findViewById(R.id.list_diary);
                                    data = showDB();
                                    listAdapter = null;
                                    list_diary.setAdapter(listAdapter);
                                }
                            }
                        });
                        alertDialog.show();
                    }else{
                        list_diary = (ListView) view.findViewById(R.id.list_diary);
                        data = showDB();
                        listAdapter = new DiaryListAdapter(getContext(), R.layout.list_layout, data);
                        list_diary.setAdapter(listAdapter);
                        list_diary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(getContext(), Diary_Update.class);
                                int code = data.get(position).getCode();
                                intent.putExtra("code", code);
                                startActivity(intent);
                            }
                        });
                        list_diary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                                alertDialog.setMessage(data.get(position).getTitle()+"을(를) 삭제하시겠습니까?");
                                alertDialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int code = data.get(position).getCode();
                                        deleteDB(code);
                                        showDB();
                                        listAdapter.notifyDataSetChanged();
                                    }
                                });
                                alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                alertDialog.show();
                                return false;
                            }
                        });
                    }


                }
            });
            if(flag == 1){
                return view;
            }else{
                return null;
            }


        }
    }

    //다이어리 설정
    public static class Diary_Setting extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tab_setting, container, false);
            secretSwitch = (Switch)view.findViewById(R.id.switch1);
            secretEditText = (EditText)view.findViewById(R.id.secret_editText);
            secretSaveBtn = (Button)view.findViewById(R.id.secret_save_btn);
            secretSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        //On
                        secretEditText.setVisibility(View.VISIBLE);

                    }else{
                        //Off
                        secretEditText.setVisibility(View.INVISIBLE);


                    }
                }
            });
            secretSaveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = secretEditText.getText().toString();
                    passDB(str);
                }
            });
            return view;
        }
    }



    public static void InsertDB(){
        db = dbHelper.getWritableDatabase();
        String sql = "insert into diary ('title', 'date', 'contents') values(?,?,?)";
        SQLiteStatement st = db.compileStatement(sql);
        st.bindString(1,edit_title.getText().toString());
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분 ss초");
        String writeTime = sdf.format(date);
        st.bindString(2,writeTime);
        st.bindString(3,edit_contents.getText().toString());
        st.execute();

        mFirebaseDatabase.getReference("users").setValue(edit_contents.getText().toString());

        db.close();
        edit_title.setText("");
        edit_contents.setText("");
    }


    public static ArrayList<Diary> showDB(){
        data.clear();
        db = dbHelper.getReadableDatabase();
        String sql = "select * from diary";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            Diary diary = new Diary();
            diary.setCode(cursor.getInt(0));
            diary.setTitle(cursor.getString(1));
            diary.setDate(cursor.getString(2));
            diary.setContents(cursor.getString(3));
            data.add(diary);
        }
        cursor.close();
        db.close();
        return data;
    }


    public static void deleteDB(int code){
        db = dbHelper.getReadableDatabase();
        String sql = "delete from diary where code="+code;
        db.execSQL(sql);
        db.close();
    }


    public static void passDB(String str){
        db = pdbHelper.getWritableDatabase();
        String sql = "insert into passwd values('"+str+"')";
        db.execSQL(sql);
        db.close();
        secretEditText.setText("");
    }

    public static String checkPass(){
        db = pdbHelper.getReadableDatabase();
        String sql = "select * from passwd";
        Cursor cursor = db.rawQuery(sql, null);
        String pass="";
        while(cursor.moveToNext()){
            pass = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return pass;
    }
}