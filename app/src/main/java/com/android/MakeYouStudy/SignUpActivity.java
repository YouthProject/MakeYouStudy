package com.android.MakeYouStudy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity  {

    FirebaseAuth firebaseAuth;
    String email = "";
    String password = "";
    EditText ed_singupeamil, ed_signuppassword;
    Button bt_newsignup, bt_backmain;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase;// ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ed_singupeamil=(EditText)findViewById(R.id.ed_signupemail);
        ed_signuppassword=(EditText)findViewById(R.id.ed_signuppassword);
        bt_newsignup=(Button)findViewById(R.id.bt_newsignup);
        bt_backmain=(Button)findViewById(R.id.bt_backmain);


        bt_newsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=ed_singupeamil.getText().toString();
                password=ed_signuppassword.getText().toString();

                if(isValidEmail() && isValidPasswd()) {
                    createUser(email, password);
                }

            }
        });
        bt_backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            Toast.makeText(SignUpActivity.this,"이메일이 공백입니다.",Toast.LENGTH_SHORT);
            return false;
        }
        else {
            return true;
        }
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (password.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(SignUpActivity.this,"패스워드가 공백입니다.",Toast.LENGTH_SHORT);
            return false;

        } else {
            return true;
        }
    }

    private void createUser(final String email, final String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                            Toast.makeText(SignUpActivity.this, "성공", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                            startActivity(intent);

                            String cu = firebaseAuth.getUid();

                            userinfo userdata = new userinfo(email, password);

                            mDatabase.child("users").child(cu).setValue(userdata);



                        } else {
                            // 회원가입 실패
                            Toast.makeText(SignUpActivity.this, R.string.failed_signup, Toast.LENGTH_SHORT).show();
                        }

                    }
                });   FirebaseUser user = firebaseAuth.getCurrentUser();


    }
}
