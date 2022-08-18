package com.example.mynavigationapp;

import static com.example.mynavigationapp.MainActivity.closeDrawer;
import static com.example.mynavigationapp.MainActivity.openDrawer;
import static com.example.mynavigationapp.MainActivity.redirectActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout=findViewById(R.id.drawer_layout);

    }
    public void ClickMenu (View view) {
        openDrawer(drawerLayout);
    }
    public void ClickLogo(View view)
    {
        closeDrawer(drawerLayout);
    }
    public void ClickDashboard(View view)
    {
        recreate();
    }
    public void ClickProfile(View view)
    {
        redirectActivity(this,ProfileActivity.class);
    }
    public void ClickLogout(View view)
    {
        MainActivity.ClickLogout(this);

    }
    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}