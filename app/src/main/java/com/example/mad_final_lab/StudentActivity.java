package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mad_final_lab.Database.DBHelper;

import java.util.List;

public class StudentActivity extends AppCompatActivity {


    private TextView wstudent;
    private ListView listView;
    List<Messages> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        wstudent = findViewById(R.id.wstudent);
        listView = findViewById(R.id.welcomestudent);


        final Intent intent = getIntent();
        wstudent.setText("Welcome " + intent.getStringExtra("username"));

        DBHelper dbHelper = new DBHelper(StudentActivity.this);

        messageList = dbHelper.readAllMessages();

        ListAdapter listAdapter = new ArrayAdapter<>(StudentActivity.this, android.R.layout.simple_list_item_1, messageList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent messageview = new Intent(StudentActivity.this, MessageView.class);
                messageview.putExtra("subject", messageList.get(i).getSubject());
                messageview.putExtra("message", messageList.get(i).getMessage());
                startActivity(messageview);

            }
        });
    }
}
