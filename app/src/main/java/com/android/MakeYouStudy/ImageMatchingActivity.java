package com.android.MakeYouStudy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgproc.Imgproc;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import dmax.dialog.SpotsDialog;

import static org.opencv.imgproc.Imgproc.COLOR_BGR2HSV;


public class ImageMatchingActivity extends AppCompatActivity  {

    ImageView imageView;
    Mat img1;
    Bitmap bitmap, capturebmp;
    Mat img2;

    TextView textView;
    Button btnCamera;
    Double metric_val;

    FirebaseAuth firebaseAuth;
    private FirebaseUser user;
//    DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();

    int position;
    int size;

    boolean CheckSuccess;
    int count;

    AlertDialog waitingDialog;
    private long pressedTime;

    private Activity activity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matching);

        imageView = (ImageView)findViewById(R.id.result);
        textView = (TextView)findViewById(R.id.textView1);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference().child("images").child(user.getUid());

        waitingDialog = new SpotsDialog.Builder().
                setContext(this)
                .setMessage("Please waiting...")
                .setCancelable(false).build();

        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Camera1 ", "Success");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        checksize();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            capturebmp = (Bitmap) extras.get("data");
            CheckSuccess = false;
            count = 0;

            imageDownload();

            Log.d("TAGjt", "tkffuwnj");
        }
    }

    public void imageDownload(){
        storageRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {


                for (StorageReference item : listResult.getItems()) {

                    final long ONE_MEGABYTE = 1024 * 1024;
                    item.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            waitingDialog.show();
                            Log.d("TAGjt", "GetSuccess");
                            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                            matching(capturebmp);
                            count++;
                            Log.d("count :" , count+"");
                            if(count== 5){
                                if(CheckSuccess == true){
                                    if(waitingDialog.isShowing()){
                                        waitingDialog.dismiss();
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("checkMatching", CheckSuccess);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }else {
                                    if(waitingDialog.isShowing()){
                                        waitingDialog.dismiss();
                                    }
                                    dialogUpload();
                                }
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle any errors
                            Log.d("TAGjt", "GetFailed");
                            Log.e("TAGjt1", exception.toString());
                        }
                    });

                }
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    public void matching( Bitmap bitmap2){

        if(!OpenCVLoader.initDebug()){
            Log.d("start error : ", "OpenCV not loaded");
        } else {
            Log.d("start : ", "OpenCV loaded");
            try {

                Mat hist_1 = new Mat();
                Mat hist_2 = new Mat();

                MatOfFloat ranges = new MatOfFloat(0f, 256f);
                MatOfInt histSize = new MatOfInt(25);

                img1 = new Mat();
                Utils.bitmapToMat(bitmap, img1);
                Imgproc.cvtColor(img1, img1, COLOR_BGR2HSV);
                Imgproc.calcHist(Arrays.asList(img1), new MatOfInt(0), new Mat(), hist_1, histSize, ranges);
                Core.normalize(hist_1, hist_1, 0, 1, Core.NORM_MINMAX);

                img2 = new Mat();
                Utils.bitmapToMat(bitmap2, img2);
                Imgproc.cvtColor(img2, img2, COLOR_BGR2HSV);
                Imgproc.calcHist(Arrays.asList(img2), new MatOfInt(0), new Mat(), hist_2, histSize, ranges);
                Core.normalize(hist_2, hist_2, 0, 1, Core.NORM_MINMAX);

                metric_val = Imgproc.compareHist(hist_1, hist_2, Imgproc.HISTCMP_BHATTACHARYYA);// 0이 일치
                if(metric_val < 0.4) {
                    CheckSuccess = true;

                }else { CheckSuccess = false; }


            } catch (Exception e) {

            }
        }
    }

    public void dialogUpload(){
        activity = this;

        AlertDialog.Builder alertdialog = new AlertDialog.Builder(activity);
        alertdialog.setMessage("해당 사진을 등록하시겠습니까?");

        // 확인버튼 - 등록
        alertdialog.setPositiveButton("등록", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checksize();
                imageUpload(capturebmp);
                //Toast.makeText(activity, "등록 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 취소버튼
        alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog alert = alertdialog.create();
        alert.setTitle("출석체크 실패");

        alert.show();

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
                Toast.makeText(ImageMatchingActivity.this, "이미지 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Log.d("Upload : ", "Success");
                Toast.makeText(ImageMatchingActivity.this, "이미지가 성공적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                Log.d("TEST", "SIZE : " + size + "POSITION : " + position);
                mdatabase.child("image").child(user.getUid()).child("size").setValue(size+"");
                mdatabase.child("image").child(user.getUid()).child("position").setValue(position+"");
            }
        });
    }

    // size와 position값
    public void checksize(){
        mdatabase.child("image").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                size = Integer.parseInt(dataSnapshot.child("size").getValue(String.class));
                position = Integer.parseInt(dataSnapshot.child("position").getValue(String.class));
                countPosition();

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


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if ( pressedTime == 0){
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            pressedTime = System.currentTimeMillis();
        }else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if(seconds > 2000){
                pressedTime = 0;
            }else {
                Intent intent = new Intent();
                intent.putExtra("checkMatching", false);

                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

}
