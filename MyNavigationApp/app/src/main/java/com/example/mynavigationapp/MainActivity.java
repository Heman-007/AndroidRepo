package com.example.mynavigationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu (View view) {
        openDrawer(drawerLayout);
        
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view)
    {
        closeDrawer(drawerLayout);
    }

     public static void closeDrawer(DrawerLayout drawerLayout) {
         if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
             drawerLayout.closeDrawer(GravityCompat.START);
         }
     }

        public void ClickHome(View view)
         {
             recreate();
         }
         public void ClickDashboard(View view)
         {
             redirectActivity(this,DashboardActivity.class);
         }
         public void ClickProfile(View view)
         {
             redirectActivity(this,ProfileActivity.class);
         }


    public static void ClickLogout(Activity activity)
         {
             AlertDialog.Builder builder = new AlertDialog.Builder(activity);
             builder.setTitle("Logout");
             builder.setMessage("Are you sure you want to logout ?");
             builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     activity.finishAffinity();
                     System.exit(0);
                 }

             });
         }
         public static void redirectActivity(Activity activity, Class aClass)
         {
             Intent intent = new Intent(activity,aClass);
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             activity.startActivity(intent);



         }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

}
