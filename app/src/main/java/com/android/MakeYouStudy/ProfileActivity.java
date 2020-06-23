package com.android.MakeYouStudy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import dmax.dialog.SpotsDialog;

public class ProfileActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    public static final int UP_COUNT = 1;
    public static final int GET_SIZE = 2;

    FirebaseAuth firebaseAuth;
    private TextView te_textview;
    private Button bt_logout, bt_delect,takeapicture;
    private ImageView imageViewcount;
    DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();
    static final int REQUEST_IMAGE_CAPTURE = 1;

    //firebase에 자신의 책상 image 등록해주기 위함
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private FirebaseUser user;
    int position;
    int size;
    android.app.AlertDialog waitingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        te_textview = (TextView) findViewById(R.id.te_textview);
        bt_logout = (Button) findViewById(R.id.bt_logut);
        bt_delect = (Button) findViewById(R.id.bt_delect);
        imageViewcount = (ImageView)findViewById(R.id.imageViewCount);

        takeapicture=(Button)findViewById(R.id.takeapicture);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        te_textview.setText(user.getEmail() + "으로 로그인 하였습니다.");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mDatabase;
        String cu = firebaseAuth.getUid();

        storageRef = storage.getReference().child("images").child(user.getUid());
        checksize(GET_SIZE);

        waitingDialog = new SpotsDialog.Builder().
                setContext(this)
                .setMessage("Please waiting...")
                .setCancelable(false).build();


        // 로그아웃 버튼 리스너
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutDialog();
            }
        });

        //회원탈퇴 리스너
        bt_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });

        //사진 찍기 리스너너
       takeapicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }

    // 사진 찍기
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }

    @Override //사진촬영후 사진 저장
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        checksize(GET_SIZE);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK && data.hasExtra("data")) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            if (bitmap != null) {
                checksize(UP_COUNT);
                imageUpload(bitmap);
            }
        }
    }



    public void Dialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원 탈퇴");
        builder.setMessage("탈퇴 하시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ProfileActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                    firebaseAuth.getInstance().signOut();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                String cu = firebaseAuth.getUid();
                mdatabase.child("users").child(cu).setValue(null);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        builder.show();
    }


    public void logoutDialog(){
        AlertDialog.Builder bui=new AlertDialog.Builder(this);
        bui.setTitle("로그아웃");
        bui.setMessage("로그아웃 하시겠습니까?");
        bui.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseAuth.getInstance().signOut();
                firebaseAuth.signOut();
                LoginManager.getInstance().logOut();
                finish();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                finish();
            }
        }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        bui.show();
    }

    //firebase에 책상 image upload method
    public void imageUpload(Bitmap bmpImage){
        waitingDialog.show();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmpImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data1 = baos.toByteArray();

        StorageReference filepath = storageRef.child(position+"");

        UploadTask uploadTask = filepath.putBytes(data1);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {

                if(waitingDialog.isShowing())
                    waitingDialog.dismiss();

                Toast.makeText(ProfileActivity.this, "이미지 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                if(waitingDialog.isShowing())
                    waitingDialog.dismiss();

                Log.d("Upload : ", "Success");
                Toast.makeText(ProfileActivity.this, "이미지가 성공적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                Log.d("TEST", "SIZE : " + size + "POSITION : " + position);
                mdatabase.child("image").child(user.getUid()).child("size").setValue(size+"");
                mdatabase.child("image").child(user.getUid()).child("position").setValue(position+"");
            }
        });
    }


    // image database가 null인지 확인 후 null이면 초기화
    public void checksize(int mode){
                mdatabase.child("image").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d(TAG, "CHECKSIZE가 실행");
                        if(dataSnapshot.getValue() == null){
                            Log.d("Checksize : ", "Uid child is null");
                            // 처음 등록할 때 size값과 position값을 초기화시켜준다.
                            mdatabase.child("image").child(user.getUid()).child("size").setValue("0");
                            mdatabase.child("image").child(user.getUid()).child("position").setValue("0");
                            size = 0;
                            position = 0;
                        }else{
                            size = Integer.parseInt(dataSnapshot.child("size").getValue(String.class));
                            position = Integer.parseInt(dataSnapshot.child("position").getValue(String.class));

                        }
                        if(mode == UP_COUNT){
                            countPosition();
                        }
                        if(size > 4){
                            imageViewcount.setImageDrawable(getDrawable(R.drawable.ic_green));
                        }
                    }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
    // user별 database에 저장된 현재 position값 계산
    public void countPosition(){
        if(size < 5){ size++; }
        if(position > 3){ position = 0; } else{ position++; }
    }
}


