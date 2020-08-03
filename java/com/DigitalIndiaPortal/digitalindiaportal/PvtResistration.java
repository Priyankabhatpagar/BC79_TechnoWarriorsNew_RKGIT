package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PvtResistration extends AppCompatActivity {
    EditText pvtresNmae, pvtresEmail,pvtresPassword;
    Button resButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_resistration);
        pvtresNmae=findViewById(R.id.resCompany);
        pvtresEmail=findViewById(R.id.pvtresEmail);
        pvtresPassword=findViewById(R.id.pvtresPassword);
        resButton=findViewById(R.id.pvtres);
        firebaseAuth=FirebaseAuth.getInstance();
        resButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =pvtresNmae.getText().toString().trim();
                String email = pvtresEmail.getText().toString().trim();
                String password = pvtresPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(PvtResistration.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(PvtResistration.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    Toast.makeText(PvtResistration.this, "Password Length too sort", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(PvtResistration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(PvtResistration.this, "Registration SuccessFull", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),PrivateDeshBoard.class));


                                } else {


                                }

                                // ...
                            }
                        });
            }
        });
    }
}