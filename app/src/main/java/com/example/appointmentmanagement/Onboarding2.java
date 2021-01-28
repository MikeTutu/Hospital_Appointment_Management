package com.example.appointmentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

public class Onboarding2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);

        button = (Button) findViewById(R.id.btnBack);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboarding2.this, Onboarding1.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.btnGetStarted);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(Onboarding2.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
