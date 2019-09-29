package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mad_final_lab.Database.DBHelper;

public class RegisterActivity extends AppCompatActivity {

    private Button registerbtn;
    private EditText username, password;
    private RadioGroup radioGroup;
    private RadioButton teacher, student, radioButton;
    long i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerbtn = findViewById(R.id.registerR);
        username = findViewById(R.id.usernameR);
        password = findViewById(R.id.passwordR);
        radioGroup = findViewById(R.id.usergroup);
        teacher = findViewById(R.id.teacherCheck);
        student = findViewById(R.id.studentCheck);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int check = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(check);

                if(username.getText().toString() == null || password.getText().toString() == null || radioButton.getText().toString() == null) {


                    Toast.makeText(RegisterActivity.this, "Some fileds has been missed", Toast.LENGTH_SHORT).show();

                }else {

                    DBHelper dbHelper = new DBHelper(RegisterActivity.this);
                    i = dbHelper.registerUser(username.getText().toString(), password.getText().toString(), radioButton.getText().toString());
                    System.out.println(i);
                    Toast.makeText(RegisterActivity.this, "Registration Successfull!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}
