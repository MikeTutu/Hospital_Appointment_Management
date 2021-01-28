package com.example.appointmentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

      /*  BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.appts);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.book:
                        startActivity(new Intent(getApplicationContext()
                                ,BookAppts.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profileDet:
                        startActivity(new Intent(getApplicationContext()
                                ,ProfileDetails.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.appts:
                        return true;
                }
                return false;
            }
        });*/
    }
}
