package com.example.appointmentmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class Onboarding1 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        button = (Button) findViewById(R.id.btnNext);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboarding1.this, Onboarding2.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.btnSkip);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(Onboarding1.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
