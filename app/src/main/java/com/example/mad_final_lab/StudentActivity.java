package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {


    private TextView wstudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        wstudent = findViewById(R.id.welcomestudent);

        Intent intent = getIntent();
        wstudent.setText("Welcome " + intent.getStringExtra("username"));
    }
}
