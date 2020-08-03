package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class AddTender extends AppCompatActivity {
    EditText addTenTitle, addTenEmail, addTenPhone, addTenDes, addTenOther, addTenUrl;
    Button addTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tender);
        addTenTitle = findViewById(R.id.addTenTitle);
        addTenEmail = findViewById(R.id.addTenEmail);
        addTenPhone = findViewById(R.id.addTenPhone);
        addTenDes = findViewById(R.id.addTenDes);
        addTenOther = findViewById(R.id.addTenDetail);
        addTenUrl = findViewById(R.id.addTenUrl);
        addTen = findViewById(R.id.addTen);

        addTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadTender();
            }
        });

    }

    public void UploadTender() {
        FreelancingModel uploadJob = new FreelancingModel(
                addTenTitle.getText().toString(),
                addTenEmail.getText().toString(),
                addTenPhone.getText().toString(),
                addTenDes.getText().toString(),
                addTenOther.getText().toString(),
                addTenUrl.getText().toString()


        );
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("Tender").child(currentDate).setValue(uploadJob).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddTender.this, "add SuccessFull", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}