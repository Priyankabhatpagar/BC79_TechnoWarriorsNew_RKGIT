package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GovtRegistration extends AppCompatActivity {
    TextView resNmae,resEmail,resPassword;
    Button resButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_registration);
        resNmae=findViewById(R.id.resName);
        resEmail=findViewById(R.id.resEmail);
        resPassword=findViewById(R.id.resPassword);
        resButton=findViewById(R.id.govtRegistation);
             firebaseAuth=FirebaseAuth.getInstance();
       resButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name =resNmae.getText().toString().trim();
               String email = resEmail.getText().toString().trim();
               String password = resPassword.getText().toString().trim();
               if (TextUtils.isEmpty(email)) {
                   Toast.makeText(GovtRegistration.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
               }
               if (TextUtils.isEmpty(password)) {
                   Toast.makeText(GovtRegistration.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
               }
               if (password.length()<6){
                   Toast.makeText(GovtRegistration.this, "Password Length too sort", Toast.LENGTH_SHORT).show();
               }
               firebaseAuth.createUserWithEmailAndPassword(email, password)
                       .addOnCompleteListener(GovtRegistration.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Toast.makeText(GovtRegistration.this, "Registration SuccessFull", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(getApplicationContext(),GovernmentDeshBoard.class));


                               } else {

                               }

                               // ...
                           }
                       });

           }
       });


        }


}