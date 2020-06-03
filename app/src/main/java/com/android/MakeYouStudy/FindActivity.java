package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FindActivity extends AppCompatActivity{
    EditText findeamil;
    Button but_findpasssword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        findeamil = (EditText) findViewById(R.id.findemail);
        but_findpasssword = (Button) findViewById(R.id.but_findpassword);
        firebaseAuth = FirebaseAuth.getInstance();

        String eamilAddress=findeamil.getText().toString();

        but_findpasssword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eamilAddress = findeamil.getText().toString().trim();

                firebaseAuth.sendPasswordResetEmail(eamilAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(FindActivity.this, "이메일 보냈습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(FindActivity.this, "이메일 보내기 실패.", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}
