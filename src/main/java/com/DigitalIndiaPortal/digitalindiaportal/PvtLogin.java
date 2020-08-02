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

public class PvtLogin extends AppCompatActivity {
    EditText pvtEmail,pvtPassword;
    Button pvtloginbutton,pvtresButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_login);
        pvtEmail=findViewById(R.id.pvtloginEmail);
        pvtPassword=findViewById(R.id.pvtloginPassword);
        pvtloginbutton=findViewById(R.id.pvtloginButton);
        pvtresButton=findViewById(R.id.pvtregistrationButton);
        firebaseAuth=FirebaseAuth.getInstance();

       pvtloginbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=pvtEmail.getText().toString().trim();
               String password=pvtPassword.getText().toString().trim();
               if (TextUtils.isEmpty(email)){

                   Toast.makeText(PvtLogin.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
               }
               if (TextUtils.isEmpty(password)){

                   Toast.makeText(PvtLogin.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
               }

               firebaseAuth.signInWithEmailAndPassword(email, password)
                       .addOnCompleteListener(PvtLogin.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Toast.makeText(PvtLogin.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(getApplicationContext(),PrivateDeshBoard.class));
                               } else {

                                   Toast.makeText(PvtLogin.this, "Wrong Details", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

           }
       });
       pvtresButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent jumRes = new Intent(PvtLogin.this,PvtResistration.class);
               startActivity(jumRes);

           }
       });
    }
}