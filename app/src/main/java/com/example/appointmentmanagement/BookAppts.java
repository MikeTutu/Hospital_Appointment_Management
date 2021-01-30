package com.example.appointmentmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.util.Log;
import android.app.ListActivity;





public class BookAppts extends  AppCompatActivity {

    String sDoctor[] = {"Doc. Esi Owusu", "Doc. Mike Tetteh", "Doc. Larry Sowah", "Doc. Jeffri Bannor", "Doc. Esi Owusu", "Doc. Mike Tetteh", "Doc. Larry Sowah", "Doc. Jeffri Bannor"};
    String sTime[] = {"9:00AM-10:00AM", "01:00PM-02:00PM", "04:00PM-05:00PM", "12:00PM-01:00PM", "9:00AM-10:00AM", "01:00PM-02:00PM", "04:00PM-05:00PM", "12:00PM-01:00PM"};
    int icons[] = {R.drawable.green_cicle, R.drawable.green_cicle, R.drawable.ambient_circle, R.drawable.green_cicle, R.drawable.ambient_circle, R.drawable.red_circle, R.drawable.green_cicle, R.drawable.red_circle};


    Button mBtn, alertBn;
    TextView mTv;
    Calendar c;
    DatePickerDialog dpd;
    ListView listView;
    boolean dateChosenBefore;
    String bookdate = "31/1/2021";
    ArrayList<String> entries;

    ArrayAdapter<String> adapter, adapterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appts);

     /*   listView = (ListView)findViewById(R.id.listView);
        String [] values = new String[] {
          "Doc 1", "Doc 2", "Doc 3", "Doc 4", "Doc 5", "Doc 2", "Doc 3", "Doc 4", "Doc 5"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BookAppts.this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



                @Override
                public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(BookAppts.this, itemValue, Toast.LENGTH_SHORT).show();
            }

        });*/


        mTv = (TextView) findViewById(R.id.mTv);
        mBtn = (Button) findViewById(R.id.btnPick);
     //   ThisAdapter adapter = new ThisAdapter(this, sDoctor, sTime, icons);
        //listView.setAdapter(adapter);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(BookAppts.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        mTv.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);


                        String bdate = mTv.getText().toString();

                        if (bdate.equals(bookdate)) {
                            listView = (ListView) findViewById(R.id.listView);
                            listView = (ListView) findViewById(R.id.listView);
                            String[] values = new String[]{
                                    "Doc. Michael Frimpong", "Doc. Esi Owusu", "Doc. Rose Sally", "Doc. Mike Tetteh", "Doc. Jeffi Bannor", "Doc. Mike Tetteh", "Doc. Esi Owusu", "Doc. Rose Sally4", "Doc. Mike Tetteh"
                            };
                            int[] icons = new int[]{R.drawable.green_cicle, R.drawable.green_cicle, R.drawable.ambient_circle, R.drawable.green_cicle, R.drawable.ambient_circle, R.drawable.red_circle, R.drawable.green_cicle, R.drawable.red_circle};


                            ArrayAdapter adapter = new ArrayAdapter<String>(BookAppts.this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

                            listView.setAdapter(adapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    String itemValue = (String) listView.getItemAtPosition(position);

                                    Toast.makeText(BookAppts.this, itemValue, Toast.LENGTH_SHORT).show();


                                }

                            });

                        }
                        else {
                            listView = (ListView) findViewById(R.id.listView);
                            String[] valuesB = new String[]{
                                    "Doc. Jeffi Bannor", "Doc. Mike Tetteh", "Doc. Michael Frimpong", "Doc. Esi Owusu", "Doc. Rose Sally", "Doc. Mike Tetteh", "Doc. Jeffi Bannor"
                            };
                            adapterB = new ArrayAdapter<String>(BookAppts.this, android.R.layout.simple_list_item_1, android.R.id.text1, valuesB);
                            listView.setAdapter(adapterB);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    String itemValue = (String) listView.getItemAtPosition(position);
                                    Toast.makeText(BookAppts.this, itemValue, Toast.LENGTH_SHORT).show();


                                }

                            });
                        }


                    }
                }, year, month, day);
                dpd.show();

            }
        });


        //Start Nav Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.book);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.book:
                        return true;
                    case R.id.profileDet:
                        startActivity(new Intent(getApplicationContext()
                                , ProfileDetails.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.appts:
                        startActivity(new Intent(getApplicationContext()
                                , Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });//End of Bar

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing
            }
        });
        List<String> purpose = new ArrayList<String>();
        purpose.add("Regular Checkup");
        purpose.add("Dental Checkup");
        purpose.add("Results collection");
        purpose.add("Medication");
        purpose.add("Surgery");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, purpose);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);







    }

    //Create Adapter
  /*  class ThisAdapter extends ArrayAdapter<String> {
        Context context;
        String rDoctor[], rTime[];
        int rIcon[];

        ThisAdapter(Context c, String doctor[], String time[], int icon[]) {
            super(c, R.layout.row, R.id.doc, doctor);
            this.context = c;
            this.rDoctor = doctor;
            this.rTime = time;
            this.rIcon = icon;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row_appointments = layoutInflater.inflate(R.layout.row, parent, false);

            ImageView images = row_appointments.findViewById(R.id.image_doc);
            TextView myDoctors = row_appointments.findViewById(R.id.doc);
            TextView myTimes = row_appointments.findViewById(R.id.time);

            images.setImageResource(rIcon[position]);
            myDoctors.setText(rDoctor[position]);
            myTimes.setText(rTime[position]);


            return row_appointments;
        }
    }*/
    //End

}
