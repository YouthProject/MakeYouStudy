package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

    // view object
    private  TabLayout tabLayout;
    private  ViewPager viewPager;
    public static EditText edit_title, edit_contents;
    public static Button save_btn;
    public static Button refresh_btn;
    public static ListView list_diary;
    public static DiaryListAdapter listAdapter;

    public static int flag = 0;
    private static ArrayList<Diary> data;

    //파이어베이스
    private static FirebaseAuth firebaseAuth;
    private static FirebaseUser user;
    private static DatabaseReference mDatabaseReference; // 데이터베이스의 주소를 저장합니다.
    private static FirebaseDatabase mFirebaseDatabase; // 데이터베이스에 접근할 수 있는 진입점 클래스입니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        // firebase
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid());


        data = new ArrayList<>();


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
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



    //다이어리 작성 내부클래스
    public static class Diary_Write extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tab_write, container, false);
            edit_title = (EditText) view.findViewById(R.id.edit_title_write);
            edit_contents = (EditText) view.findViewById(R.id.edit_contents_write);
            save_btn = (Button) view.findViewById(R.id.save_btn_write);
            save_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    save_btn.setEnabled(false);
                    // btn disabled 1sec
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            save_btn.setEnabled(true);
                        }
                    }, 1000);
                    if(edit_title.getText().toString().getBytes().length<=0&& edit_contents.getText().toString().getBytes().length<=0){

                    }else{
                        InsertDB();
                    }
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
                    if(edit_title.getText().toString().getBytes().length<=0&& edit_contents.getText().toString().getBytes().length<=0){

                    list_diary = (ListView) view.findViewById(R.id.list_diary);
                    data = showDB();
                    Log.d("TEST", data.toString());
                    listAdapter = new DiaryListAdapter(getContext(), R.layout.list_layout, data);

                    list_diary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getContext(), Diary_Update.class);
                            intent.putExtra("date", data.get(position).getDate());
                            intent.putExtra("title", data.get(position).getTitle());
                            intent.putExtra("contents", data.get(position).getContents());
                            startActivity(intent);
                        }
                    });
                    list_diary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                        @Override
                        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                            alertDialog.setMessage(data.get(position).getTitle() + "을(를) 삭제하시겠습니까?");
                            alertDialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String code = data.get(position).getDate();
                                    deleteDB(code);
                                    showDB();
                                }
                            });
                            alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertDialog.show();
                            return true;
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


    public static void InsertDB(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String writeTime = sdf.format(date);
        String getEdit=edit_contents.getText().toString();
            // Firebase
            mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid()).child(writeTime);
            mDatabaseReference.setValue(edit_title.getText() + "/" + edit_contents.getText());
        
        edit_title.setText("");
        edit_contents.setText("");
    }

    public static ArrayList<Diary> showDB(){
        mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid());
        if(mDatabaseReference != null){
            mFirebaseDatabase.getReference().child("diary").child(user.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    data.clear();
                    list_diary.setAdapter(listAdapter);
                    int code = 1;
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        String[] fbData = splitData(snapshot.getValue().toString());
                        Diary diary = new Diary();
                        diary.setCode(code);
                        diary.setTitle(fbData[0]);
                        diary.setContents(fbData[1]);
                        diary.setDate(snapshot.getKey());
                        data.add(diary);
                        code += 1;
                    }
                    list_diary.setAdapter(listAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {   }
            });
            return data;
        }else{ return null; }
    }

    public static void deleteDB(String date){
        mFirebaseDatabase.getReference().child("diary").child(user.getUid()).child(date).setValue(null);
    }
    private static String[] splitData(String data){
        String[] splitText = data.split("/");
        return splitText;
    }
}