package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {
    EditText useEmail,userPassword;
    Button loginClick,resClick;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        useEmail=findViewById(R.id.userEmail);
        userPassword=findViewById(R.id.userPassword);
        loginClick=findViewById(R.id.userClickL);
        resClick=findViewById(R.id.userClickR);
                 auth=FirebaseAuth.getInstance();
        loginClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=useEmail.getText().toString().trim();
                String password=userPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){

                    Toast.makeText(UserLogin.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){

                    Toast.makeText(UserLogin.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(UserLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(),UserDetail.class));
                                    Toast.makeText(UserLogin.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(UserLogin.this, "Input Wrongs", Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });

            }
        });
                resClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent jumpRes = new Intent(UserLogin.this,UserRegistration.class);
                        startActivity(jumpRes);
                    }
                });
    }
}