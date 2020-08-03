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

public class AddFreeLancing extends AppCompatActivity {
    EditText addFreeTitle, addFreeEmail, addFreePhone, addFreeDes, addFreeOther, addFreeUrl;
    Button addFreeWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_free_lancing);
        addFreeTitle = findViewById(R.id.addFreeTitle);
        addFreeEmail = findViewById(R.id.addFreeEmail);
        addFreePhone = findViewById(R.id.addFreePhone);
        addFreeDes = findViewById(R.id.addFreeDes);
        addFreeOther = findViewById(R.id.addFreeDetail);
        addFreeUrl = findViewById(R.id.addFreeUrl);
        addFreeWork = findViewById(R.id.addFreeWork);

        addFreeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    UploadFreeWork();
            }
        });

    }

    public void UploadFreeWork() {
        FreelancingModel uploadJob = new FreelancingModel(
                addFreeTitle.getText().toString(),
                addFreeEmail.getText().toString(),
                addFreePhone.getText().toString(),
                addFreeDes.getText().toString(),
                addFreeOther.getText().toString(),
                addFreeUrl.getText().toString()


        );
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("FreeLancing").child(currentDate).setValue(uploadJob).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddFreeLancing.this, "add SuccessFull", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}