package com.example.appointmentmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    ImageView button;

    ListView listView;
    String sDoctor[] = {"Doc. Esi Owusu", "Doc. Mike Tetteh", "Doc. Larry Sowah", "Doc. Jeffri Bannor", "Mike", "Mike", "Mike", "Mike" };
    String sRm [] ={"Room 204", "Room 121", "Room 121", "Room 121", "Room 121", "Room 121", "Room 121", "Room 121"};
    String sDate [] = {"Monday, 18 January 2021","Wednesday, 14 February 2021", "Monday, 18 January 2021","Friday, 21 February 2021","Friday, 21 February 2021","Friday, 21 February 2021","Friday, 21 February 2021","Friday, 21 February 2021"};
    String sTime [] = {"9:00-10:00", "01:00-02:00", "04:00-05:00", "12:00-01:00", "12:00-01:00", "12:00-01:00", "12:00-01:00", "12:00-01:00"};

    int icons[] = {R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor, R.drawable.ic_doctor};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (ImageView) findViewById(R.id.setting);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Settings.class);
                startActivity(intent);
            }
        });


        //Start_of_bottom_Nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

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
        });

        //End_Of_Bottom_Nav

        listView = findViewById(R.id.listView);

       MyAdapter adapter = new MyAdapter(this, sDoctor, sRm, sDate, sTime, icons);
        listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rDoctor[], rRm[], rDate[], rTime[];
        int rIcon[];

        MyAdapter(Context c, String doctor[], String rm[], String date[], String time[], int icon[]){
            super(c, R.layout.row, R.id.doc, doctor);
            this.context = c;
            this.rDoctor = doctor;
            this.rRm = rm;
            this.rDate = date;
            this.rTime = time;
            this.rIcon = icon;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image_doc);
            TextView myDoctors = row.findViewById(R.id.doc);
            TextView myRooms = row.findViewById(R.id.rm);
            TextView myDates = row.findViewById(R.id.date);
            TextView myTimes = row.findViewById(R.id.time);

            images.setImageResource(rIcon[position]);
            myDoctors.setText(rDoctor[position]);
            myRooms.setText(rRm[position]);
            myDates.setText(rDate[position]);
            myTimes.setText(rTime[position]);

            return row;
        }
    }


}
