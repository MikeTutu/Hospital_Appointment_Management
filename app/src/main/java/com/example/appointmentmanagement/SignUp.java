package com.example.appointmentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.util.Patterns;
import android.widget.Toast;
import android.os.Bundle;



public class SignUp extends AppCompatActivity{
    final int MIN_PASSWORD_LENGTH = 6;
    Button button;
    EditText etFullname, etEmail, etId, etHall, etAge, etPhone, etPassword;
    EditText et;
    String st;
    int radioId;
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewInitializations();

        radioGroup = findViewById(R.id.radioGroup);


        et = findViewById(R.id.editID);
        button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, ProfileDetails.class);
                radioId = radioGroup.getCheckedRadioButtonId();

               if(validateInput()) {
                   st = et.getText().toString();
                   intent.putExtra("Value", st);
                   startActivity(intent);
               }

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



    void viewInitializations() {
        etFullname = findViewById(R.id.fullname);
        etEmail = findViewById(R.id.emailtxt);
        etPassword = findViewById(R.id.et_password);
        etId= findViewById(R.id.editID);
        etHall = findViewById(R.id.hall);
        etAge = findViewById(R.id.et_age);
        etPhone = findViewById(R.id.phone);
        radioButton = findViewById(radioId);

    }
    // Checking if the input in form is valid
    boolean validateInput() {
        if (etFullname.getText().toString().equals("")) {
            etFullname.setError("Please Enter Full Name");
            return false;
        }
        if (etId.getText().toString().equals("")) {
            etId.setError("Please Enter  ID");
            return false;
        }
        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Please Enter Email");
            return false;
        }
        if (etHall.getText().toString().equals("")) {
            etHall.setError("Please Enter Hall Name");
            return false;
        }
        if (etAge.getText().toString().equals("")) {
            etAge.setError("Please Enter Age");
            return false;
        }
        if (etPhone.getText().toString().equals("")) {
            etPhone.setError("Please Enter Contact Number");
            return false;
        }
        if (etPassword.getText().toString().equals("")) {
            etPassword.setError("Please Enter Password");
            return false;
        }

        // checking the proper email format
        if (!isEmailValid(etEmail.getText().toString())) {
            etEmail.setError("Please Enter Valid Email");
            return false;
        }

        // checking minimum password Length
        if (etPassword.getText().length() < MIN_PASSWORD_LENGTH) {
            etPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters");
            return false;
        }


        return true;
    }

    boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    // Hook Click Event

    public void performSignUp (View v) {
        if (validateInput()) {

            // connect to server with this

            String FullName = etFullname.getText().toString();
            String ID = etId.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String hall = etHall.getText().toString();
            String Age = etAge.getText().toString();
            String Gender = radioButton.getText().toString();
            String Phone = etPhone.getText().toString();


            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();


            // Here you can call you API

        }
    }


}
