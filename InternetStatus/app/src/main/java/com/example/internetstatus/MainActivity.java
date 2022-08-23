package com.example.internetstatus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button notifyBtn;
    BroadcastReceiver broadcastReceiver = null;
    public Button move;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new InternetReceiver();
        InternetStatus();

        notifyBtn = findViewById(R.id.notify_btn);
        move = findViewById(R.id.Next);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,second.class);
                startActivity(intent);
            }
        });


        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //notification code

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("Message");
                builder.setContentText("Hello Hemant spam detected");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true); //for swiping the notification so it disappears

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build()); //Notifying user inside the app with help of builder

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) //for checking the version greater and if yes creating channel for notification
                {
                    NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }

            }
        });
    }
    public void InternetStatus(){
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {

        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
}