package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserRegistration extends AppCompatActivity {
    EditText resNameR,resEmailR,resPassR;
    Button resButtonR;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        resNameR=findViewById(R.id.userNameR);
        resEmailR=findViewById(R.id.userEmailR);
        resPassR=findViewById(R.id.userPasswordR);
        resButtonR=findViewById(R.id.userClickRes);
        firebaseAuth=FirebaseAuth.getInstance();

        resButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=resNameR.getText().toString().trim();
                String email=resEmailR.getText().toString().trim();
                String password=resPassR.getText().toString().trim();
                if (TextUtils.isEmpty(email)){

                    Toast.makeText(UserRegistration.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){

                    Toast.makeText(UserRegistration.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    Toast.makeText(UserRegistration.this, "Password Length too sort", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(UserRegistration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),UserLogin.class));
                                    Toast.makeText(UserRegistration.this, "Registration SuccessFul", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(UserRegistration.this, "Something Wrong", Toast.LENGTH_SHORT).show();


                                }

                                // ...
                            }
                        });


            }



        });
    }
}