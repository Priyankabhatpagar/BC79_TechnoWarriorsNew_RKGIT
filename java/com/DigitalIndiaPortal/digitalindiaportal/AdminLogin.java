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

public class AdminLogin extends AppCompatActivity {
    EditText adminEmail,adminPassword;
    Button clickAdmin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adminEmail=findViewById(R.id.adminEmail);
        adminPassword=findViewById(R.id.adminPassword);
        clickAdmin=findViewById(R.id.adminLogin);
        firebaseAuth=FirebaseAuth.getInstance();

        clickAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=adminEmail.getText().toString().trim();
                String password=adminPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){

                    Toast.makeText(AdminLogin.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){

                    Toast.makeText(AdminLogin.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(AdminLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),AdminPanel.class));
                                    Toast.makeText(AdminLogin.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(AdminLogin.this, "Something Wrong", Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }
        });

    }
}