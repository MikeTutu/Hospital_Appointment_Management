package com.example.appointmentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;

import android.os.Bundle;



public class SignUp extends AppCompatActivity{

    Button button;
    EditText et;
    String st;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et = findViewById(R.id.editID);
        button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, ProfileDetails.class);
                st = et.getText().toString();
                intent.putExtra("Value", st);
                startActivity(intent);


            }
        });

        button = (Button) findViewById(R.id.signin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });


    }


}
