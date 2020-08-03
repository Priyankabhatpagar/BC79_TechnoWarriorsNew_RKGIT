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

public class AddBusIdea extends AppCompatActivity {
    EditText addBusTitle,addBusEmail,addBusPhone,addBusDes,addBusDetail,addBusUrl;
    Button addBusCLick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus_idea);
        addBusTitle = findViewById(R.id.addBusTitle);
        addBusEmail = findViewById(R.id.addBusEmail);
        addBusPhone = findViewById(R.id.addbusPhone);
        addBusDes = findViewById(R.id.addBusDes);
        addBusDetail = findViewById(R.id.addBusDetail);
        addBusUrl = findViewById(R.id.addBusUrl);
        addBusCLick = findViewById(R.id.addBusCLick);
        addBusCLick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      UploadBus();
            }
        });



    }

    public void UploadBus() {
        BusinessModel uploadJob = new BusinessModel(
                addBusTitle.getText().toString(),
                addBusEmail.getText().toString(),
                addBusPhone.getText().toString(),
                addBusDes.getText().toString(),
                addBusDetail.getText().toString(),
                addBusUrl.getText().toString()


        );
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("BusinessIdea").child(currentDate).setValue(uploadJob).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddBusIdea.this, "add SuccessFull", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}