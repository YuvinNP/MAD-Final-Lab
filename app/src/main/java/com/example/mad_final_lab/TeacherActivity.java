package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TeacherActivity extends AppCompatActivity {

    private TextView wteacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        wteacher = findViewById(R.id.welcometeacher);

        Intent intent = getIntent();
        wteacher.setText("Welcome " + intent.getStringExtra("username"));
    }
}
