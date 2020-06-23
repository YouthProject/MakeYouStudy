package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    private static final int MULTIPLE_PERMISSIONS = 101;
    private String[] permission = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
    };

    int index = (int) (Math.random() * 10);
    int res = ran[index];

    public static final int ran[]= {
            R.drawable.good1, R.drawable.good2, R.drawable.good3,
            R.drawable.good4, R.drawable.good5, R.drawable.good6,
            R.drawable.good7, R.drawable.good8, R.drawable.good9, R.drawable.good10
    };

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private Button buttonCalendar;
    private Button buttonTimeTable;
    private Button buttonDiary;
    private Button buttonProfile;
    private Button buttonAttendanceRate;
    private ImageView imageViewGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한설정 부분
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkPermission();
            // Android 10 이상부터 사용자가 직접 OverlayPermission을 설정해 줘야함
            if(!Settings.canDrawOverlays(getApplicationContext())){
                checkOverlayPermission();
            }
        }
        //initializing views
        buttonCalendar = (Button)findViewById(R.id.buttonCalendar);
        buttonTimeTable = (Button)findViewById(R.id.buttonTimeTable);
        buttonDiary = (Button)findViewById(R.id.buttonDiary);
        buttonProfile = (Button)findViewById(R.id.buttonProfile);
        buttonAttendanceRate = (Button)findViewById(R.id.buttonAttendance);
        imageViewGood = (ImageView)findViewById(R.id.good);
        imageViewGood.setImageResource(res);

        // 유저가 로그인하지 않은 상태라면 LoginActivity 실행
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        else{
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //button event
            buttonCalendar.setOnClickListener(this);
            buttonTimeTable.setOnClickListener(this);
            buttonDiary.setOnClickListener(this);
            buttonProfile.setOnClickListener(this);
            buttonAttendanceRate.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buttonCalendar){
            startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
        }
        if(view == buttonTimeTable){
            startActivity(new Intent(getApplicationContext(), TimeTableActivity.class));
        }
        if(view == buttonDiary){
            startActivity(new Intent(getApplicationContext(), DiaryActivity.class));
        }
        if(view == buttonProfile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        if(view == buttonAttendanceRate){
            startActivity(new Intent(getApplicationContext(), AttendanceRateActivity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MULTIPLE_PERMISSIONS:{
                if(grantResults.length > 0){
                    for (int i = 0; i < permissions.length; i++){
                        if(permissions[i].equals(this.permission[i])){
                            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                                showToast_PermissionDeny();
                            }
                        }
                    }
                }else{
                    showToast_PermissionDeny();
                }
                return;
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private boolean checkPermission(){
        int result;
        List<String> permissionList = new ArrayList<>();
        for (String pm : permission){
            result = ContextCompat.checkSelfPermission(this, pm);
            if(result != PackageManager.PERMISSION_GRANTED){
                permissionList.add(pm);
            }
        }if(!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
    // alarm overlay permission check 알람이 시작될 때 Activity를 띄워줌
    private void checkOverlayPermission(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("백그라운드 재생 권한").setMessage("백그라운드에서 Make You Study의 타임테이블 알람을 울리기 위해서 권한을 허용해 주셔야 합니다.");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    Uri uri = Uri.parse("package:" + getPackageName());
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri);

                    startActivityForResult(intent, 5469);
                }catch (Exception e){
                    Log.d("MainActivity", "" + e);
                }
            }
        });
        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast_PermissionDeny();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    // Permission check notification
    private void showToast_PermissionDeny() {
        Toast.makeText(this, "권한 요청에 동의 해주셔야 이용 가능합니다. 설정에서 권한 허용 하시기 바랍니다.", Toast.LENGTH_SHORT).show();
        finish();
    }
}