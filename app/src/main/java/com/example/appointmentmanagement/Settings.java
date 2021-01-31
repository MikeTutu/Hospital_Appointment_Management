package com.example.appointmentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
ImageButton btnlogout, btnsts,btn_acc;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        builder = new AlertDialog.Builder(Settings.this);


        btnsts = (ImageButton) findViewById(R.id.btnsts);
        btnsts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoweb = new Intent(Intent.ACTION_VIEW,Uri.parse("https://sts.ug.edu.gh/services/"));
                startActivity(gotoweb);
            }
        });

        btn_acc = (ImageButton)findViewById(R.id.btnmyAcc);
        btn_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, ProfileDetails.class);
                startActivity(intent);
            }
        });

        btnlogout = (ImageButton)findViewById(R.id.btnLogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
                builder.setMessage("Are you sure you want to LOGOUT?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Settings.this, SignIn.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),"Logged Out Successfully",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Cancelled",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Confirm Action");
                alert.show();
            }
        });


    }
}
