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

public class ProfileActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    private TextView te_textview;
    private Button bt_logout, bt_delect,takepicture,retry,uplo;
    ImageView takeimage,photoimage;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();
    CallbackManager callbackManager;

    private final int REQ_CODE_SELECT_IMAGE=1000;
    private String mImgPath=null;
    private String mImgTitle=null;
    private String mImgOrient=null;
    private Uri filePath;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int PICK_IMAGE=2;

    //firebase에 자신의 책상 image 등록해주기 위함
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private FirebaseUser user;
    int position;
    int size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        te_textview = (TextView) findViewById(R.id.te_textview);
        bt_logout = (Button) findViewById(R.id.bt_logut);
        bt_delect = (Button) findViewById(R.id.bt_delect);

        takepicture=(Button)findViewById(R.id.takepicture);
        takeimage=(ImageView)findViewById(R.id.takeimage);
        retry=(Button)findViewById(R.id.retry);
        firebaseAuth = FirebaseAuth.getInstance();
        photoimage=(ImageView)findViewById(R.id.photoimage);
        user = firebaseAuth.getCurrentUser();
        te_textview.setText("반갑습니다.\n" + user.getEmail() + "으로 로그인 하였습니다.");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mDatabase;
        String cu = firebaseAuth.getUid();

        storageRef = storage.getReference().child("images").child(user.getUid());

        // test listall
        storageRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item : listResult.getItems()){
                    Log.d("item", item.toString());
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        // 로그아웃 버튼 리스너
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutDialog();
            }
        });
        bt_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });

        // 이미지 불러오기 버튼 리스너
        takepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checksize(); // 이미지를 불러오기전에 size와 positon 초기화
                Log.d("TTT", "size" + size + " / position" + position);

                // 사진을 가져오는 Activity 실행
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent,PICK_IMAGE);
                /*
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "이미지를 선택하세요."), 0);*/
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checksize();
                dispatchTakePictureIntent();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "이미지를 선택하세요."), 0);
            }
        });
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }

    @Override //갤러리에서 이미지 불러온 후 이미지를 저장
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    imageUpload(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK && data.hasExtra("data")) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            filePath = data.getData();;
            if (bitmap != null) {
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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmpImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data1 = baos.toByteArray();

        StorageReference filepath = storageRef.child(position+"");

        UploadTask uploadTask = filepath.putBytes(data1);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(ProfileActivity.this, "이미지 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Log.d("Upload : ", "Success");
                Toast.makeText(ProfileActivity.this, "이미지가 성공적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                Log.d("TEST", "SIZE : " + size + "POSITION : " + position);
                mdatabase.child("image").child(user.getUid()).child("size").setValue(size+"");
                mdatabase.child("image").child(user.getUid()).child("position").setValue(position+"");
            }
        });
    }


    // image database가 null인지 확인 후 null이면 초기화
    public void checksize(){
                mdatabase.child("image").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
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
                            countPosition();
                        }
                    }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
    // user별 database에 저장된 현재 position값 계산
    public void countPosition(){
        if(size < 4){ size++; }
        if(position > 3){ position = 0; } else{ position++; }
    }
}


