package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NewEntry_Upto2Years extends AppCompatActivity {

    EditText Name;
    EditText BloodGroup;
    EditText MotherName;
    EditText FatherName;
    TextView UID;
    TextView DOB;
    Button Date;
    Button Submit;
    Button RetrieveUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_upto2_years);

        UID = findViewById(R.id.inputUID);
        Name = findViewById(R.id.inputName);
        DOB = findViewById(R.id.showDOB);
        Date = findViewById(R.id.selectDOB);
        Submit = findViewById(R.id.submit);
        BloodGroup = findViewById(R.id.BloodGroup);
        MotherName = findViewById(R.id.MotherName);
        FatherName = findViewById(R.id.FatherName);
        RetrieveUID = findViewById(R.id.retrieveUID);

        DBHandlerUpto2Years handler = new DBHandlerUpto2Years(this,"Upto2Years",null,1);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Define the mapping of menu item IDs to corresponding activities
            Map<Integer, Class<?>> activityMap = new HashMap<>();
            activityMap.put(R.id.info, Info.class);
            activityMap.put(R.id.home, MainActivity.class);
            activityMap.put(R.id.profile, profile.class);

            // Check if the selected item is present in the activityMap
            Class<?> destinationActivity = activityMap.get(item.getItemId());
            if (destinationActivity != null) {
                // Start the corresponding activity
                startActivity(new Intent(getApplicationContext(), destinationActivity));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Instance of Calendar
                final Calendar c = Calendar.getInstance();

                //Getting current day,month,year
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(NewEntry_Upto2Years.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String fullday="",fullMonth="";
                        if(dayOfMonth<=9) {
                            fullday = "0" + dayOfMonth;
                        } else {
                            fullday = Integer.toString(dayOfMonth);
                        }
                        if(month<9&&month>=0){
                            fullMonth = "0"+ (month + 1);
                        }else{
                            fullMonth = Integer.toString(month+1);
                        }
                        DOB.setText(" "+fullday+"/"+(fullMonth)+"/"+year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.AddUpto2Years(new classUpto2Years(Integer.parseInt(UID.getText().toString()),Name.getText().toString(),DOB.getText().toString(),BloodGroup.getText().toString(),MotherName.getText().toString(),FatherName.getText().toString()));
                Toast.makeText(NewEntry_Upto2Years.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),ChildUpto2.class   ));
            }
        });

        RetrieveUID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UID.setText(handler.getLastUIDValueUpto2Years());
            }
        });
    }
}