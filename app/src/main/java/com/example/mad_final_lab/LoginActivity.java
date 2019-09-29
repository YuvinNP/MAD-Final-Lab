package com.example.mad_final_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_final_lab.Database.DBHelper;

public class LoginActivity extends AppCompatActivity {

    private Button loginbtn, registerBtn;
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginbtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.regiterBtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbHelper = new DBHelper(LoginActivity.this);

                if(dbHelper.login(username.getText().toString(), password.getText().toString())){

                    Toast.makeText(LoginActivity.this, "Login Successfull!", Toast.LENGTH_SHORT).show();

                    if(dbHelper.getType(username.getText().toString()).equals("Teacher")){

                        Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
                        intent.putExtra("username", username.getText().toString());
                        startActivity(intent);
                    }
                    else {

                        Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                        intent.putExtra("username", username.getText().toString());
                        startActivity(intent);
                    }

                }
                else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
