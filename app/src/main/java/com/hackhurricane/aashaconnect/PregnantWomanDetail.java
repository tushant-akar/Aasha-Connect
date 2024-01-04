package com.hackhurricane.aashaconnect;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PregnantWomanDetail extends AppCompatActivity {

    TextView ChildName;
    TextView UIDValue;
    TextView HusbandName;
    TextView DOB;
    TextView BloodGroup;
    TextView Height;
    TextView Weight;
    TextView Hemoglobin;
    TextView BP;
    TextView Urine;
    TextView Abdomen;

    EditText HusbandName_edit;
    EditText BloodGroup_edit;
    EditText ChildName_edit;
    EditText Height_edit;
    EditText Weight_edit;
    EditText Hemoglobin_edit;
    EditText BP_edit;
    EditText Urine_edit;
    EditText Abdomen_edit;

    Button EditDetails;
    Button DeleteDetails;
    Button DateSelect;

    TextView Vaccine11_date;
    TextView Vaccine12_date;
    TextView Vaccine13_date;
    TextView Vaccine14_date;
    TextView Vaccine15_date;
    TextView Vaccine16_date;

    TextView Vaccine21_date;
    TextView Vaccine22_date;
    TextView Vaccine23_date;
    TextView Vaccine24_date;
    TextView Vaccine25_date;
    TextView Vaccine26_date;

    TextView Vaccine31_date;
    TextView Vaccine32_date;
    TextView Vaccine33_date;
    TextView Vaccine34_date;
    TextView Vaccine35_date;
    TextView Vaccine36_date;

    TextView Vaccine41_date;
    TextView Vaccine42_date;
    TextView Vaccine43_date;
    TextView Vaccine44_date;
    TextView Vaccine45_date;
    TextView Vaccine46_date;

    Button Vaccine11Date;
    Button Vaccine12Date;
    Button Vaccine13Date;
    Button Vaccine14Date;
    Button Vaccine15Date;
    Button Vaccine16Date;

    Button Vaccine21Date;
    Button Vaccine22Date;
    Button Vaccine23Date;
    Button Vaccine24Date;
    Button Vaccine25Date;
    Button Vaccine26Date;

    Button Vaccine31Date;
    Button Vaccine32Date;
    Button Vaccine33Date;
    Button Vaccine34Date;
    Button Vaccine35Date;
    Button Vaccine36Date;

    Button Vaccine41Date;
    Button Vaccine42Date;
    Button Vaccine43Date;
    Button Vaccine44Date;
    Button Vaccine45Date;
    Button Vaccine46Date;

    DBHandlerPregnantWoman handler = new DBHandlerPregnantWoman(this,"PregnantWomanData",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant_woman_detail);

        ChildName = findViewById(R.id.Child_Name);
        HusbandName = findViewById(R.id.Husband_name);
        DOB = findViewById(R.id.DateOB);
        BloodGroup = findViewById(R.id.Blood);
        UIDValue = findViewById(R.id.UID_Value);
        Height = findViewById(R.id.Height);
        Weight = findViewById(R.id.Weight);
        Hemoglobin = findViewById(R.id.Hemoglobin);
        BP = findViewById(R.id.BP);
//        Urine = findViewById(R.id.Urine);
        Abdomen = findViewById(R.id.Abdomen);

        HusbandName_edit = findViewById(R.id.HusbandName_edit);
        BloodGroup_edit = findViewById(R.id.Blood_edit);
        ChildName_edit = findViewById(R.id.Child_Name_Edit);
        Height_edit = findViewById(R.id.Height_edit);
        Weight_edit = findViewById(R.id.Weight_edit);
        Hemoglobin_edit = findViewById(R.id.Hemoglobin_edit);
        BP_edit = findViewById(R.id.BP_edit);
//        Urine_edit = findViewById(R.id.Urine_edit);
        Abdomen_edit = findViewById(R.id.Abdomen_edit);

        EditDetails = findViewById(R.id.Edit);
        DeleteDetails = findViewById(R.id.Delete);
        DateSelect = findViewById(R.id.selectDate);

        Vaccine11_date = findViewById(R.id.Vaccine11_date);
        Vaccine12_date = findViewById(R.id.Vaccine12_date);
        Vaccine13_date = findViewById(R.id.Vaccine13_date);
        Vaccine14_date = findViewById(R.id.Vaccine14_date);
        Vaccine15_date = findViewById(R.id.Vaccine15_date);
        Vaccine16_date = findViewById(R.id.Vaccine16_date);

        Vaccine21_date = findViewById(R.id.Vaccine21_date);
        Vaccine22_date = findViewById(R.id.Vaccine22_date);
        Vaccine23_date = findViewById(R.id.Vaccine23_date);
        Vaccine24_date = findViewById(R.id.Vaccine24_date);
        Vaccine25_date = findViewById(R.id.Vaccine25_date);
        Vaccine26_date = findViewById(R.id.Vaccine26_date);

        Vaccine31_date = findViewById(R.id.Vaccine31_date);
        Vaccine32_date = findViewById(R.id.Vaccine32_date);
        Vaccine33_date = findViewById(R.id.Vaccine33_date);
        Vaccine34_date = findViewById(R.id.Vaccine34_date);
        Vaccine35_date = findViewById(R.id.Vaccine35_date);
        Vaccine36_date = findViewById(R.id.Vaccine36_date);

        Vaccine41_date = findViewById(R.id.Vaccine41_date);
        Vaccine42_date = findViewById(R.id.Vaccine42_date);
        Vaccine43_date = findViewById(R.id.Vaccine43_date);
        Vaccine44_date = findViewById(R.id.Vaccine44_date);
        Vaccine45_date = findViewById(R.id.Vaccine45_date);
        Vaccine46_date = findViewById(R.id.Vaccine46_date);

        Vaccine11Date = findViewById(R.id.selectDateVaccine11);
        Vaccine12Date = findViewById(R.id.selectDateVaccine12);
        Vaccine13Date = findViewById(R.id.selectDateVaccine13);
        Vaccine14Date = findViewById(R.id.selectDateVaccine14);
        Vaccine15Date = findViewById(R.id.selectDateVaccine15);
        Vaccine16Date = findViewById(R.id.selectDateVaccine16);

        Vaccine21Date = findViewById(R.id.selectDateVaccine21);
        Vaccine22Date = findViewById(R.id.selectDateVaccine22);
        Vaccine23Date = findViewById(R.id.selectDateVaccine23);
        Vaccine24Date = findViewById(R.id.selectDateVaccine24);
        Vaccine25Date = findViewById(R.id.selectDateVaccine25);
        Vaccine26Date = findViewById(R.id.selectDateVaccine26);

        Vaccine31Date = findViewById(R.id.selectDateVaccine31);
        Vaccine32Date = findViewById(R.id.selectDateVaccine32);
        Vaccine33Date = findViewById(R.id.selectDateVaccine33);
        Vaccine34Date = findViewById(R.id.selectDateVaccine34);
        Vaccine35Date = findViewById(R.id.selectDateVaccine35);
        Vaccine36Date = findViewById(R.id.selectDateVaccine36);

        Vaccine41Date = findViewById(R.id.selectDateVaccine41);
        Vaccine42Date = findViewById(R.id.selectDateVaccine42);
        Vaccine43Date = findViewById(R.id.selectDateVaccine43);
        Vaccine44Date = findViewById(R.id.selectDateVaccine44);
        Vaccine45Date = findViewById(R.id.selectDateVaccine45);
        Vaccine46Date = findViewById(R.id.selectDateVaccine46);

        Intent intent = getIntent();
        int UID = intent.getIntExtra(PregnantWoman.EXTRA_UID,0);
        UIDValue.setText(Integer.toString(UID));

        String[] output = handler.EachUserGetPregnantWomanData(UID);

        ChildName.setText(output[1]);
        DOB.setText(String.format(" %s", output[2]));
        BloodGroup.setText(output[3]);
        HusbandName.setText(output[4]);

        Vaccine11_date.setText(output[5]);
        Vaccine12_date.setText(output[6]);
        Vaccine13_date.setText(output[7]);
        Vaccine14_date.setText(output[8]);
        Vaccine15_date.setText(output[9]);
        Vaccine16_date.setText(output[10]);

        Vaccine21_date.setText(output[11]);
        Vaccine22_date.setText(output[12]);
        Vaccine23_date.setText(output[13]);
        Vaccine24_date.setText(output[14]);
        Vaccine25_date.setText(output[15]);
        Vaccine26_date.setText(output[16]);

        Vaccine31_date.setText(output[17]);
        Vaccine32_date.setText(output[18]);
        Vaccine33_date.setText(output[19]);
        Vaccine34_date.setText(output[20]);
        Vaccine35_date.setText(output[21]);
        Vaccine36_date.setText(output[22]);

        Vaccine41_date.setText(output[23]);
        Vaccine42_date.setText(output[24]);
        Vaccine43_date.setText(output[25]);
        Vaccine44_date.setText(output[26]);
        Vaccine45_date.setText(output[27]);
        Vaccine46_date.setText(output[28]);

        Height.setText(output[29]);
        Weight.setText(output[30]);
        Hemoglobin.setText(output[31]);
        BP.setText(output[32]);
//        Urine.setText(output[33]);
        Abdomen.setText(output[34]);

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
////                        handler.UpdateDOBPregnantWomanData(UID,DOBFull);
//                    }
//                },
//                        year,month,day);
//                datePickerDialog.show();
                setDateText(DOB);
            }
        });

        Vaccine11Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine11_date);
            }
        });
        Vaccine12Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine12_date);
            }
        });
        Vaccine13Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine13_date);
            }
        });
        Vaccine14Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine14_date);
            }
        });
        Vaccine15Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine15_date);
            }
        });
        Vaccine16Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine16_date);
            }
        });

        Vaccine21Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine21_date);
            }
        });
        Vaccine22Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine22_date);
            }
        });
        Vaccine23Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine23_date);
            }
        });
        Vaccine24Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine24_date);
            }
        });
        Vaccine25Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine25_date);
            }
        });
        Vaccine26Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine26_date);
            }
        });

        Vaccine31Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine31_date);
            }
        });
        Vaccine32Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine32_date);
            }
        });
        Vaccine33Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine33_date);
            }
        });
        Vaccine34Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine34_date);
            }
        });
        Vaccine35Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine35_date);
            }
        });
        Vaccine36Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine36_date);
            }
        });

        Vaccine41Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine41_date);
            }
        });
        Vaccine42Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine42_date);
            }
        });
        Vaccine43Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine43_date);
            }
        });
        Vaccine44Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine44_date);
            }
        });
        Vaccine45Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine45_date);
            }
        });
        Vaccine46Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDateText(Vaccine46_date);
            }
        });

        DeleteDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PregnantWomanDetail.this,R.style.AlertDialogTheme);
                builder.setTitle("Confirmation Dialog").setMessage("Do you want to delete?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.DeletePregnantWomanData(UID);
                        startActivity(new Intent((getApplicationContext()),PregnantWoman.class));
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
                PregnantWomanDetail.this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
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
        HusbandName.setVisibility(View.GONE);
        HusbandName_edit.setVisibility(View.VISIBLE);
        HusbandName_edit.setText((HusbandName.getText().toString()));

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

        Hemoglobin.setVisibility(View.GONE);
        Hemoglobin_edit.setVisibility(View.VISIBLE);
        Hemoglobin_edit.setText(Hemoglobin.getText().toString());

        BP.setVisibility(View.GONE);
        BP_edit.setVisibility(View.VISIBLE);
        BP_edit.setText(BP.getText().toString());

//        Urine.setVisibility(View.GONE);
//        Urine_edit.setVisibility(View.VISIBLE);
//        Urine_edit.setText(Urine.getText().toString());

        Abdomen.setVisibility(View.GONE);
        Abdomen_edit.setVisibility(View.VISIBLE);
        Abdomen_edit.setText(Abdomen.getText().toString());

//        Vaccine11Date.setVisibility(View.VISIBLE);

        if(Vaccine11_date.getText().toString().isEmpty()){
            Vaccine11Date.setVisibility(View.VISIBLE);
//            Vaccine11_date.setVisibility(View.GONE);
        }
        if(Vaccine12_date.getText().toString().isEmpty()){
            Vaccine12Date.setVisibility(View.VISIBLE);
//            Vaccine12_date.setVisibility(View.GONE);
        }
        if(Vaccine13_date.getText().toString().isEmpty()){
            Vaccine13Date.setVisibility(View.VISIBLE);
//            Vaccine13_date.setVisibility(View.GONE);
        }
        if(Vaccine14_date.getText().toString().isEmpty()){
            Vaccine14Date.setVisibility(View.VISIBLE);
//            Vaccine14_date.setVisibility(View.GONE);
        }
        if(Vaccine15_date.getText().toString().isEmpty()){
            Vaccine15Date.setVisibility(View.VISIBLE);
//            Vaccine15_date.setVisibility(View.GONE);
        }
        if(Vaccine16_date.getText().toString().isEmpty()){
            Vaccine16Date.setVisibility(View.VISIBLE);
//            Vaccine16_date.setVisibility(View.GONE);
        }

        if(Vaccine21_date.getText().toString().isEmpty()){
            Vaccine21Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine22_date.getText().toString().isEmpty()){
            Vaccine22Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine23_date.getText().toString().isEmpty()){
            Vaccine23Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine24_date.getText().toString().isEmpty()){
            Vaccine24Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine25_date.getText().toString().isEmpty()){
            Vaccine25Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine26_date.getText().toString().isEmpty()){
            Vaccine26Date.setVisibility(View.VISIBLE);
        }

        if(Vaccine31_date.getText().toString().isEmpty()){
            Vaccine31Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine32_date.getText().toString().isEmpty()){
            Vaccine32Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine33_date.getText().toString().isEmpty()){
            Vaccine33Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine34_date.getText().toString().isEmpty()){
            Vaccine34Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine35_date.getText().toString().isEmpty()){
            Vaccine35Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine36_date.getText().toString().isEmpty()){
            Vaccine36Date.setVisibility(View.VISIBLE);
        }

        if(Vaccine41_date.getText().toString().isEmpty()){
            Vaccine41Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine42_date.getText().toString().isEmpty()){
            Vaccine42Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine43_date.getText().toString().isEmpty()){
            Vaccine43Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine44_date.getText().toString().isEmpty()){
            Vaccine44Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine45_date.getText().toString().isEmpty()){
            Vaccine45Date.setVisibility(View.VISIBLE);
        }
        if(Vaccine46_date.getText().toString().isEmpty()){
            Vaccine46Date.setVisibility(View.VISIBLE);
        }

        EditDetails.setText("Save");
    }

    public void setToSaveMode(int UID,DBHandlerPregnantWoman handler){
        HusbandName_edit.setVisibility(View.GONE);
        HusbandName.setVisibility(View.VISIBLE);
        HusbandName.setText(Objects.requireNonNull(HusbandName_edit.getText()).toString());
//        handler.UpdateHusbandNamePregnantWomanData(UID,HusbandName.getText().toString());
        handler.UpdateValue(UID,"HusbandName",HusbandName.getText().toString());

        DateSelect.setVisibility(View.GONE);
//        handler.UpdateDOBPregnantWomanData(UID,DOB.getText().toString());
        handler.UpdateValue(UID,"DOB",DOB.getText().toString());

        BloodGroup_edit.setVisibility(View.GONE);
        BloodGroup.setVisibility(View.VISIBLE);
        BloodGroup.setText(Objects.requireNonNull(BloodGroup_edit.getText()).toString());
//        handler.UpdateBloodPregnantWomanData(UID,BloodGroup.getText().toString());
        handler.UpdateValue(UID,"BloodGroup",BloodGroup.getText().toString());

        Height_edit.setVisibility(View.GONE);
        Height.setVisibility(View.VISIBLE);
        Height.setText(Objects.requireNonNull(Height_edit.getText()).toString());
//        handler.UpdateHeightPregnantWomanData(UID,Height.getText().toString());
        handler.UpdateValue(UID,"Height",Height.getText().toString());

        Weight_edit.setVisibility(View.GONE);
        Weight.setVisibility(View.VISIBLE);
        Weight.setText(Objects.requireNonNull(Weight_edit.getText()).toString());
//        handler.UpdateWeightPregnantWomanData(UID,Weight.getText().toString());
        handler.UpdateValue(UID,"Weight",Weight.getText().toString());

        Hemoglobin_edit.setVisibility(View.GONE);
        Hemoglobin.setVisibility(View.VISIBLE);
        Hemoglobin.setText(Objects.requireNonNull(Hemoglobin_edit.getText()).toString());
        handler.UpdateValue(UID,"Hemoglobin",Hemoglobin.getText().toString());

        BP_edit.setVisibility(View.GONE);
        BP.setVisibility(View.VISIBLE);
        BP.setText(Objects.requireNonNull(BP_edit.getText()).toString());
        handler.UpdateValue(UID,"BP",BP.getText().toString());

//        Urine_edit.setVisibility(View.GONE);
//        Urine.setVisibility(View.VISIBLE);
//        Urine.setText(Objects.requireNonNull(Urine_edit.getText()).toString());
//        handler.UpdateValue(UID,"Urine",Urine.getText().toString());

        Abdomen_edit.setVisibility(View.GONE);
        Abdomen.setVisibility(View.VISIBLE);
        Abdomen.setText(Objects.requireNonNull(Abdomen_edit.getText()).toString());
        handler.UpdateValue(UID,"Abdomen",Abdomen.getText().toString());


        if(Vaccine11Date.getVisibility()==View.VISIBLE||Vaccine12Date.getVisibility()==View.VISIBLE||Vaccine13Date.getVisibility()==View.VISIBLE||Vaccine14Date.getVisibility()==View.VISIBLE||Vaccine15Date.getVisibility()==View.VISIBLE||Vaccine16Date.getVisibility()==View.VISIBLE||Vaccine21Date.getVisibility()==View.VISIBLE||Vaccine22Date.getVisibility()==View.VISIBLE||Vaccine23Date.getVisibility()==View.VISIBLE||Vaccine24Date.getVisibility()==View.VISIBLE||Vaccine25Date.getVisibility()==View.VISIBLE||Vaccine26Date.getVisibility()==View.VISIBLE||Vaccine31Date.getVisibility()==View.VISIBLE||Vaccine32Date.getVisibility()==View.VISIBLE||Vaccine33Date.getVisibility()==View.VISIBLE||Vaccine34Date.getVisibility()==View.VISIBLE||Vaccine35Date.getVisibility()==View.VISIBLE||Vaccine36Date.getVisibility()==View.VISIBLE||Vaccine41Date.getVisibility()==View.VISIBLE||Vaccine42Date.getVisibility()==View.VISIBLE||Vaccine43Date.getVisibility()==View.VISIBLE||Vaccine44Date.getVisibility()==View.VISIBLE||Vaccine45Date.getVisibility()==View.VISIBLE||Vaccine46Date.getVisibility()==View.VISIBLE){
            Vaccine11Date.setVisibility(View.GONE);
//            handler.UpdateVaccine11PregnantWomanData(UID,Vaccine11_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine11",Vaccine11_date.getText().toString());
            Vaccine12Date.setVisibility(View.GONE);
//            handler.UpdateVaccine12PregnantWomanData(UID,Vaccine12_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine12",Vaccine12_date.getText().toString());
            Vaccine13Date.setVisibility(View.GONE);
//            handler.UpdateVaccine13PregnantWomanData(UID,Vaccine13_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine13",Vaccine13_date.getText().toString());
            Vaccine14Date.setVisibility(View.GONE);
//            handler.UpdateVaccine14PregnantWomanData(UID,Vaccine14_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine14",Vaccine14_date.getText().toString());
            Vaccine15Date.setVisibility(View.GONE);
//            handler.UpdateVaccine15PregnantWomanData(UID,Vaccine15_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine15",Vaccine15_date.getText().toString());
            Vaccine16Date.setVisibility(View.GONE);
//            handler.UpdateVaccine16PregnantWomanData(UID,Vaccine16_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine16",Vaccine16_date.getText().toString());

            Vaccine21Date.setVisibility(View.GONE);
//            handler.UpdateVaccine21PregnantWomanData(UID,Vaccine21_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine21",Vaccine21_date.getText().toString());
            Vaccine22Date.setVisibility(View.GONE);
//            handler.UpdateVaccine22PregnantWomanData(UID,Vaccine22_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine22",Vaccine22_date.getText().toString());
            Vaccine23Date.setVisibility(View.GONE);
//            handler.UpdateVaccine23PregnantWomanData(UID,Vaccine23_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine23",Vaccine23_date.getText().toString());
            Vaccine24Date.setVisibility(View.GONE);
//            handler.UpdateVaccine24PregnantWomanData(UID,Vaccine24_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine24",Vaccine24_date.getText().toString());
            Vaccine25Date.setVisibility(View.GONE);
//            handler.UpdateVaccine25PregnantWomanData(UID,Vaccine25_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine25",Vaccine25_date.getText().toString());
            Vaccine26Date.setVisibility(View.GONE);
//            handler.UpdateVaccine26PregnantWomanData(UID,Vaccine26_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine26",Vaccine26_date.getText().toString());

            Vaccine31Date.setVisibility(View.GONE);
//            handler.UpdateVaccine31PregnantWomanData(UID,Vaccine31_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine31",Vaccine31_date.getText().toString());
            Vaccine32Date.setVisibility(View.GONE);
//            handler.UpdateVaccine32PregnantWomanData(UID,Vaccine32_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine32",Vaccine32_date.getText().toString());
            Vaccine33Date.setVisibility(View.GONE);
//            handler.UpdateVaccine33PregnantWomanData(UID,Vaccine33_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine33",Vaccine33_date.getText().toString());
            Vaccine34Date.setVisibility(View.GONE);
//            handler.UpdateVaccine34PregnantWomanData(UID,Vaccine34_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine34",Vaccine34_date.getText().toString());
            Vaccine35Date.setVisibility(View.GONE);
//            handler.UpdateVaccine35PregnantWomanData(UID,Vaccine35_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine35",Vaccine35_date.getText().toString());
            Vaccine36Date.setVisibility(View.GONE);
//            handler.UpdateVaccine36PregnantWomanData(UID,Vaccine36_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine36",Vaccine36_date.getText().toString());

            Vaccine41Date.setVisibility(View.GONE);
//            handler.UpdateVaccine41PregnantWomanData(UID,Vaccine41_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine41",Vaccine41_date.getText().toString());
            Vaccine42Date.setVisibility(View.GONE);
//            handler.UpdateVaccine42PregnantWomanData(UID,Vaccine42_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine42",Vaccine42_date.getText().toString());
            Vaccine43Date.setVisibility(View.GONE);
//            handler.UpdateVaccine43PregnantWomanData(UID,Vaccine43_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine43",Vaccine43_date.getText().toString());
            Vaccine44Date.setVisibility(View.GONE);
//            handler.UpdateVaccine44PregnantWomanData(UID,Vaccine44_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine44",Vaccine44_date.getText().toString());
            Vaccine45Date.setVisibility(View.GONE);
//            handler.UpdateVaccine45PregnantWomanData(UID,Vaccine45_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine45",Vaccine45_date.getText().toString());
            Vaccine46Date.setVisibility(View.GONE);
//            handler.UpdateVaccine46PregnantWomanData(UID,Vaccine46_date.getText().toString());
            handler.UpdateValue(UID,"Vaccine46",Vaccine46_date.getText().toString());
        }

        EditDetails.setText("Edit");
    }

}