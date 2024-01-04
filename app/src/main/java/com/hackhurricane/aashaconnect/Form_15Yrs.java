package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Form_15Yrs extends AppCompatActivity {

    TextView ChildName;
    TextView UIDValue;
    TextView MotherName;
    TextView FatherName;
    TextView DOB;
    TextView BloodGroup;
    TextView Height;
    TextView Weight;
    TextView BMI;

    TextView Vaccine1_date;
    TextView Vaccine2_date;
    TextView Vaccine3_date;
    TextView Vaccine4_date;
    TextView Vaccine5_date;
    TextView Vaccine6_date;
    TextView Vaccine7_date;

    EditText MotherName_edit;
    EditText FatherName_edit;
    EditText BloodGroup_edit;
    EditText ChildName_edit;
    EditText Height_edit;
    EditText Weight_edit;

    Button EditDetails;
    Button DeleteDetails;
    Button DateSelect;
    Button OPV0Date;
    Button OPV1Date;
    Button OPV2Date;
    Button OPV3Date;
    Button OPV4Date;
    Button OPV5Date;
    Button OPV6Date;

    DBHandlerUpto15Years handler = new DBHandlerUpto15Years(this,"Upto15Years",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form15_yrs);

        ChildName = findViewById(R.id.Child_Name);
        MotherName = findViewById(R.id.Mother_name);
        FatherName = findViewById(R.id.Father_name);
        DOB = findViewById(R.id.DateOB);
        BloodGroup = findViewById(R.id.Blood);
        UIDValue = findViewById(R.id.UID_Value);
        Height = findViewById(R.id.Height);
        Weight = findViewById(R.id.Weight);
        BMI = findViewById(R.id.BMI);

        Vaccine1_date = findViewById(R.id.Vaccine1_date);
        Vaccine2_date = findViewById(R.id.Vaccine2_date);
        Vaccine3_date = findViewById(R.id.Vaccine3_date);
        Vaccine4_date = findViewById(R.id.Vaccine4_date);
        Vaccine5_date = findViewById(R.id.Vaccine5_date);
        Vaccine6_date = findViewById(R.id.Vaccine6_date);
        Vaccine7_date = findViewById(R.id.Vaccine7_date);

        MotherName_edit = findViewById(R.id.MotherName_edit);
        FatherName_edit = findViewById(R.id.FatherName_edit);
        BloodGroup_edit = findViewById(R.id.Blood_edit);
        ChildName_edit = findViewById(R.id.Child_Name_Edit);

        EditDetails = findViewById(R.id.Edit);
        DeleteDetails = findViewById(R.id.Delete);
        DateSelect = findViewById(R.id.selectDate);
        Height_edit = findViewById(R.id.Height_edit);
        Weight_edit = findViewById(R.id.Weight_edit);

        OPV0Date = findViewById(R.id.selectDateVaccine1);
        OPV1Date = findViewById(R.id.selectDateVaccine2);
        OPV2Date = findViewById(R.id.selectDateVaccine3);
        OPV3Date = findViewById(R.id.selectDateVaccine4);
        OPV4Date = findViewById(R.id.selectDateVaccine5);
        OPV5Date = findViewById(R.id.selectDateVaccine6);
        OPV6Date = findViewById(R.id.selectDateVaccine7);

        Intent intent = getIntent();
        int UID = intent.getIntExtra(ChildUpto15.EXTRA_UID,0);
        UIDValue.setText(Integer.toString(UID));

//        BMI.setText(BMICalculator(Double.parseDouble(Height.getText().toString()),Double.parseDouble(Weight.getText().toString())));
        BMI.setText(handler.ReturnBMI(UID));

        String[] output = handler.EachUserGetUpto15Years(UID);
        ChildName.setText(output[1]);
        DOB.setText(String.format(" %s", output[2]));
        BloodGroup.setText(output[3]);
        MotherName.setText(output[4]);
        FatherName.setText(output[5]);
        Vaccine1_date.setText(output[6]);
        Vaccine2_date.setText(output[7]);
        Vaccine3_date.setText(output[8]);
        Vaccine4_date.setText(output[9]);
        Vaccine5_date.setText(output[10]);
        Vaccine6_date.setText(output[11]);
        Vaccine7_date.setText(output[12]);
        Height.setText(output[13]);
        Weight.setText(output[14]);

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

        EditDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditDetails.getText().toString().equals("Edit")) {
                    setToEditMode();
                } else{
                    setToSaveMode(UID,handler);
                }
            }
        });

        DateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //Instance of Calendar
//                final Calendar c = Calendar.getInstance();
//
//                //Getting current day,month,year
//                int year = c.get(Calendar.YEAR);
//                int month = c.get(Calendar.MONTH);
//                int day = c.get(Calendar.DAY_OF_MONTH);
//
//
//                //variable for datepicker dialog
//                DatePickerDialog datePickerDialog = new DatePickerDialog(
//                        Form_15Yrs.this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        String DOBFull="";
//                        String fullday="",fullMonth="";
//                        if(dayOfMonth<=9) {
//                            fullday = "0" + dayOfMonth;
//                        } else {
//                            fullday = Integer.toString(dayOfMonth);
//                        }
//                        if(month<9&&month>=0){
//                            fullMonth = "0"+ (month + 1);
//                        }else{
//                            fullMonth = Integer.toString(month+1);
//                        }
//                        DOBFull = fullday+"/"+(fullMonth)+"/"+year;
//                        DOB.setText(DOBFull);
////                        handler.UpdateDOBUpto2Years(UID,DOBFull);
//                    }
//                },
//                        year,month,day);
//                datePickerDialog.show();
                setDateText(DOB);
            }
        });

        OPV0Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine1_date);
            }
        });

        OPV1Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine2_date);
            }
        });

        OPV2Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine3_date);
            }
        });

        OPV3Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine4_date);
            }
        });

        OPV4Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine5_date);
            }
        });

        OPV5Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine6_date);
            }
        });

        OPV6Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine7_date);
            }
        });

        DeleteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Form_15Yrs.this,R.style.AlertDialogTheme);
                builder.setTitle("Confirmation Dialog").setMessage("Do you want to delete?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.DeleteUpto15Years(UID);
                        startActivity(new Intent((getApplicationContext()),ChildUpto15.class));
                    }
                }).setNegativeButton("No", null);
                builder.create();
                builder.show();
            }
        });
    }

    public void setDateText(TextView T){
        //Instance of Calendar
        final Calendar c = Calendar.getInstance();

        //Getting current day,month,year
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        //variable for datepicker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                Form_15Yrs.this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String VaccineDate="";
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
                VaccineDate = fullday+"/"+(fullMonth)+"/"+year;
                T.setText(VaccineDate);
            }
        },
                year,month,day);
        datePickerDialog.show();
    }

    public void setToEditMode(){
//        ChildName.setVisibility(View.GONE);
//        ChildName_edit.setVisibility(View.VISIBLE);
//        ChildName_edit.setText((ChildName.getText().toString()));

        MotherName.setVisibility(View.GONE);
        MotherName_edit.setVisibility(View.VISIBLE);
        MotherName_edit.setText((MotherName.getText().toString()));

        FatherName.setVisibility(View.GONE);
        FatherName_edit.setVisibility(View.VISIBLE);
        FatherName_edit.setText(FatherName.getText().toString());

        DateSelect.setVisibility(View.VISIBLE);

        BloodGroup.setVisibility(View.GONE);
        BloodGroup_edit.setVisibility(View.VISIBLE);
        BloodGroup_edit.setText((BloodGroup.getText().toString()));

        Height.setVisibility(View.GONE);
        Height_edit.setVisibility(View.VISIBLE);
        Height_edit.setText(Height.getText().toString());

        Weight.setVisibility(View.GONE);
        Weight_edit.setVisibility(View.VISIBLE);
        Weight_edit.setText(Weight.getText().toString());

        if(Vaccine1_date.getText().toString().isEmpty()){
            OPV0Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine2_date.getText().toString().isEmpty()){
            OPV1Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine3_date.getText().toString().isEmpty()){
            OPV2Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine4_date.getText().toString().isEmpty()){
            OPV3Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine5_date.getText().toString().isEmpty()){
            OPV4Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine6_date.getText().toString().isEmpty()){
            OPV5Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine7_date.getText().toString().isEmpty()){
            OPV6Date.setVisibility(View.VISIBLE);
        }

        EditDetails.setText("Save");
    }

    public void setToSaveMode(int UID, DBHandlerUpto15Years handler){
//        ChildName_edit.setVisibility(View.GONE);
//        ChildName.setVisibility(View.VISIBLE);
//        ChildName.setText(Objects.requireNonNull(ChildName_edit.getText()).toString());
//        handler.UpdateNameUpto15Years(UID,ChildName.getText().toString());

        MotherName_edit.setVisibility(View.GONE);
        MotherName.setVisibility(View.VISIBLE);
        MotherName.setText(Objects.requireNonNull(MotherName_edit.getText()).toString());
//        handler.UpdateMotherNameUpto15Years(UID,MotherName.getText().toString());
        handler.UpdateValue(UID,"MotherName",MotherName.getText().toString());

        FatherName_edit.setVisibility(View.GONE);
        FatherName.setVisibility(View.VISIBLE);
        FatherName.setText(Objects.requireNonNull(FatherName_edit.getText()).toString());
//        handler.UpdateFatherNameUpto15Years(UID,FatherName.getText().toString());
        handler.UpdateValue(UID,"FatherName",FatherName.getText().toString());

        DateSelect.setVisibility(View.GONE);
//        handler.UpdateDOBUpto15Years(UID,DOB.getText().toString());
        handler.UpdateValue(UID,"DOB",DOB.getText().toString());

        BloodGroup_edit.setVisibility(View.GONE);
        BloodGroup.setVisibility(View.VISIBLE);
        BloodGroup.setText(Objects.requireNonNull(BloodGroup_edit.getText()).toString());
//        handler.UpdateBloodUpto15Years(UID,BloodGroup.getText().toString());
        handler.UpdateValue(UID,"BloodGroup",BloodGroup.getText().toString());

        Height_edit.setVisibility(View.GONE);
        Height.setVisibility(View.VISIBLE);
        Height.setText(Objects.requireNonNull(Height_edit.getText()).toString());
//        handler.UpdateHeightUpto15Years(UID,Height.getText().toString());
        handler.UpdateValue(UID,"Height",Height.getText().toString());

        Weight_edit.setVisibility(View.GONE);
        Weight.setVisibility(View.VISIBLE);
        Weight.setText(Objects.requireNonNull(Weight_edit.getText()).toString());
//        handler.UpdateWeightUpto15Years(UID,Weight.getText().toString());
        handler.UpdateValue(UID,"Weight",Weight.getText().toString());

        BMI.setText(handler.ReturnBMI(UID));

        if( OPV0Date.getVisibility()==View.VISIBLE || OPV1Date.getVisibility()==View.VISIBLE || OPV2Date.getVisibility()==View.VISIBLE || OPV3Date.getVisibility()==View.VISIBLE || OPV4Date.getVisibility()==View.VISIBLE||OPV5Date.getVisibility()==View.VISIBLE||OPV6Date.getVisibility()==View.VISIBLE){
            OPV0Date.setVisibility(View.GONE);
//            handler.UpdateVaccine1Upto15Years(UID,Vaccine1_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine1",Vaccine1_date.getText().toString());
            OPV1Date.setVisibility(View.GONE);
//            handler.UpdateVaccine2Upto15Years(UID,Vaccine2_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine2",Vaccine2_date.getText().toString());
            OPV2Date.setVisibility(View.GONE);
//            handler.UpdateVaccine3Upto15Years(UID,Vaccine3_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine3",Vaccine3_date.getText().toString());
            OPV3Date.setVisibility(View.GONE);
//            handler.UpdateVaccine4Upto15Years(UID,Vaccine4_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine4",Vaccine4_date.getText().toString());
            OPV4Date.setVisibility(View.GONE);
//            handler.UpdateVaccine5Upto15Years(UID,Vaccine5_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine5",Vaccine5_date.getText().toString());
            OPV5Date.setVisibility(View.GONE);
//            handler.UpdateVaccine6Upto15Years(UID,Vaccine6_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine6",Vaccine6_date.getText().toString());
            OPV6Date.setVisibility(View.GONE);
//            handler.UpdateVaccine7Upto15Years(UID,Vaccine7_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine7",Vaccine7_date.getText().toString());
        }

        EditDetails.setText("Edit");
    }

    public String BMICalculator(double height, double weight){
        double BMI;
        BMI = weight/(height*height);
        return String.format("%.2f",BMI);
    }
}