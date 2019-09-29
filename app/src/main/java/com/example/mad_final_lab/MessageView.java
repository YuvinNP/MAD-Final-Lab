package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MessageView extends AppCompatActivity {


    private TextView subject;
    private EditText msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_view);

        Intent intent = getIntent();

        subject = findViewById(R.id.messageTitle);
        msgText = findViewById(R.id.msg);

        subject.setText(intent.getStringExtra("subject"));
        msgText.setText(intent.getStringExtra("message"));


    }
}
