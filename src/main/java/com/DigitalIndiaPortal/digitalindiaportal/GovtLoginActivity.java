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

public class GovtLoginActivity extends AppCompatActivity {
    EditText emailEdit,passwordEdit;
    Button LoginButton,resButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_login);
        emailEdit=findViewById(R.id.loginEmail);
        passwordEdit=findViewById(R.id.loginPassword);
        LoginButton=findViewById(R.id.loginButton);
        resButton=findViewById(R.id.registrationButton);
        firebaseAuth=FirebaseAuth.getInstance();
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpRes = new Intent(GovtLoginActivity.this,GovtRegistration.class);
                startActivity(jumpRes);
            }
        });

      LoginButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email = emailEdit.getText().toString().trim();
              String password = passwordEdit.getText().toString().trim();
              if (TextUtils.isEmpty(email)) {
                  Toast.makeText(GovtLoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
              }
              if (TextUtils.isEmpty(password)) {
                  Toast.makeText(GovtLoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
              }
              firebaseAuth.signInWithEmailAndPassword(email, password)
                      .addOnCompleteListener(GovtLoginActivity.this, new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()) {
                                  Toast.makeText(GovtLoginActivity.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(getApplicationContext(),GovernmentDeshBoard.class));
                              } else {

                                  Toast.makeText(GovtLoginActivity.this, "Wrong Details", Toast.LENGTH_SHORT).show();
                              }
                          }
                      });
          }
      });
        }
    }