package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.firebase.auth.FirebaseAuthProvider.PROVIDER_ID;

public class ProfileActivity extends AppCompatActivity{
    GoogleSignInClient googleSignInClient;
    FirebaseAuth firebaseAuth;
    private TextView te_textview;
    private Button bt_logout, bt_delect;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference();
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        te_textview = (TextView) findViewById(R.id.te_textview);
        bt_logout = (Button) findViewById(R.id.bt_logut);
        bt_delect = (Button) findViewById(R.id.bt_delect);
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        te_textview.setText("반갑습니다.\n" + user.getEmail() + "으로 로그인 하였습니다.");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mDatabase;
        String cu = firebaseAuth.getUid();


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
                LoginManager.getInstance().logOut();
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


}
