package com.example.custombroadcastreciever;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ExampleBroadcastReciever exampleBroadcastReceiver = new ExampleBroadcastReciever();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(exampleBroadcastReceiver,filter);
    }

    public void onDestroy(View view) {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}