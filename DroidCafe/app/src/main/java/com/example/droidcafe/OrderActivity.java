package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    EditText name;
    EditText mobileNumber;
    EditText email;
    RadioGroup radioGroup;
    RadioButton radiobutton;
    RadioButton radioButton2;
    Button button;
    TextView Headline;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        name = findViewById(R.id.name);
        mobileNumber = findViewById(R.id.mobileNumber);
        email=findViewById(R.id.email);
        radioGroup = findViewById(R.id.radioGroup);
        radiobutton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        Headline = findViewById(R.id.Headline);
        button = findViewById(R.id.button);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (error()){
                     Intent intent = new Intent(OrderActivity.this,OrderActivity2.class);
                     startActivity(intent);
                 }
             }
         });
    }
    private boolean error()
    {
        if (mobileNumber.getText().toString().length()==0){
            Toast.makeText(OrderActivity.this,"Please fill mobile number",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mobileNumber.getText().toString().length() !=10){
            Toast.makeText(OrderActivity.this,"please enter valid mobile number",Toast.LENGTH_LONG).show();
            return false;
        }
          if(email.getText().toString().length()==0)
           {
             Toast.makeText(OrderActivity.this,"Please enter the email id",Toast.LENGTH_LONG).show();
             return false;
           }
        else if(name.getText().toString().length()==0){
            Toast.makeText(OrderActivity.this,"Enter your name",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(!radiobutton.isChecked() && !radioButton2.isChecked()){
            Toast.makeText(OrderActivity.this,"Please select your gender",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }
}