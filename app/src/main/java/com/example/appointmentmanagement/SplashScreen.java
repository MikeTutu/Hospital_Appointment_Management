package com.example.appointmentmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       timer = new Timer();
       timer.schedule(new TimerTask() {
          @Override
            public void run() {
              Intent intent = new Intent(SplashScreen.this, Onboarding1.class);
                        startActivity(intent);
                                finish();
            }
        }, 5000);
    }
}
