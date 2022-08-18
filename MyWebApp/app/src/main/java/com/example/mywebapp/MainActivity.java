package com.example.mywebapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton loginbutton =  findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(view -> {
            if (username.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equals("Heman007")){
            //password is correct
            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

            }
            else

                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

        });
    }
}