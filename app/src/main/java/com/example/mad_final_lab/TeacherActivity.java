package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_final_lab.Database.DBHelper;

public class TeacherActivity extends AppCompatActivity {

    private TextView wteacher;
    private EditText subject, message;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        wteacher = findViewById(R.id.welcometeacher);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.messageT);
        sendBtn = findViewById(R.id.sendBtn);


        final Intent intent = getIntent();
        wteacher.setText("Welcome " + intent.getStringExtra("username"));



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(TeacherActivity.this);

                if(subject.getText().toString() == null || message.getText().toString() == null){


                    Toast.makeText(TeacherActivity.this, "Some fields are empty", Toast.LENGTH_SHORT).show();

                }
                else {

                    long i = dbHelper.addMessage(intent.getStringExtra("username"), subject.getText().toString(), message.getText().toString());
                    System.out.println(i);
                    Toast.makeText(TeacherActivity.this, "Message added successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
