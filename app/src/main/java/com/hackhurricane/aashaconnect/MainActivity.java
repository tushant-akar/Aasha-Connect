package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button Yrs2;
    private Button Yrs15;
    private Button Pregnant;
    private ImageButton Export;

    ArrayList<classPregnantWoman> userListPregnantWoman;
    ArrayList<classUpto2Years> userListUpto2Years;
    ArrayList<classUpto15Years> userListUpto15Years;

    DBHandlerPregnantWoman handlerPregnantWoman = new DBHandlerPregnantWoman(this,"PregnantWomanData",null,1);
    DBHandlerUpto15Years handlerUpto15Years = new DBHandlerUpto15Years(this,"Upto15Years",null,1);
    DBHandlerUpto2Years handlerUpto2Years = new DBHandlerUpto2Years(this,"Upto2Years",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");

        Yrs2 = findViewById(R.id.small_child);
        Yrs15 = findViewById(R.id.big_child);
        Pregnant = findViewById(R.id.pregnant_woman);
        Export = findViewById(R.id.exportXL);

        Intent open_2Yrs = new Intent(this,ChildUpto2.class);
        Intent open_15Yrs = new Intent(this,ChildUpto15.class);
        Intent open_pregnant = new Intent(this,PregnantWoman.class);

        Export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    requestPermissions(permissions, 1);
                } else {
                    importData();
                }
            }
        });

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

        Yrs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(open_2Yrs);
            }
        });

        Yrs15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(open_15Yrs);
            }
        });

        Pregnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(open_pregnant);
            }
        });
    }

    private void importData() {
        userListPregnantWoman = handlerPregnantWoman.getAllUserForExcel();
        userListUpto2Years = handlerUpto2Years.getAllUserForExcel();
        userListUpto15Years = handlerUpto15Years.getAllUserForExcel();

        if(userListPregnantWoman.size()>0 || userListUpto2Years.size()>0 || userListUpto15Years.size()>0){
            createXLFile();
        }else{
            Toast.makeText(this, "Empty List", Toast.LENGTH_SHORT).show();
        }
    }

    private void createXLFile(){
        Workbook wb = new HSSFWorkbook();

        Cell cell = null;
        Sheet sheet = null;
        Row row = null;

        //Pregnant Woman Sheet

        sheet = wb.createSheet("Pregnant Woman Data");
        row = sheet.createRow(0);

        cell = row.createCell(0);
        cell.setCellValue("UID");

        cell = row.createCell(1);
        cell.setCellValue("Name");

        cell = row.createCell(2);
        cell.setCellValue("Expected Pregnancy Date");

        cell = row.createCell(3);
        cell.setCellValue("BloodGroup");

        cell = row.createCell(4);
        cell.setCellValue("HusbandName");

        cell = row.createCell(5);
        cell.setCellValue("Status");

        cell = row.createCell(6);
        cell.setCellValue("Vaccine11");

        cell = row.createCell(7);
        cell.setCellValue("Vaccine12");

        cell = row.createCell(8);
        cell.setCellValue("Vaccine13");

        cell = row.createCell(9);
        cell.setCellValue("Vaccine14");

        cell = row.createCell(10);
        cell.setCellValue("Vaccine15");

        cell = row.createCell(11);
        cell.setCellValue("Vaccine16");

        cell = row.createCell(12);
        cell.setCellValue("Vaccine21");

        cell = row.createCell(13);
        cell.setCellValue("Vaccine22");

        cell = row.createCell(14);
        cell.setCellValue("Vaccine23");

        cell = row.createCell(15);
        cell.setCellValue("Vaccine24");

        cell = row.createCell(16);
        cell.setCellValue("Vaccine25");

        cell = row.createCell(17);
        cell.setCellValue("Vaccine26");

        cell = row.createCell(18);
        cell.setCellValue("Vaccine31");

        cell = row.createCell(19);
        cell.setCellValue("Vaccine32");

        cell = row.createCell(20);
        cell.setCellValue("Vaccine33");

        cell = row.createCell(21);
        cell.setCellValue("Vaccine34");

        cell = row.createCell(22);
        cell.setCellValue("Vaccine35");

        cell = row.createCell(23);
        cell.setCellValue("Vaccine36");

        cell = row.createCell(24);
        cell.setCellValue("Vaccine41");

        cell = row.createCell(25);
        cell.setCellValue("Vaccine42");

        cell = row.createCell(26);
        cell.setCellValue("Vaccine43");

        cell = row.createCell(27);
        cell.setCellValue("Vaccine44");

        cell = row.createCell(28);
        cell.setCellValue("Vaccine45");

        cell = row.createCell(29);
        cell.setCellValue("Vaccine46");

        sheet.setColumnWidth(0, (30 * 200));
        sheet.setColumnWidth(1, (30 * 200));
        sheet.setColumnWidth(2, (30 * 200));
        sheet.setColumnWidth(3, (30 * 200));
        sheet.setColumnWidth(4, (30 * 200));
        sheet.setColumnWidth(5, (30 * 200));
        sheet.setColumnWidth(6, (30 * 200));
        sheet.setColumnWidth(7, (30 * 200));
        sheet.setColumnWidth(8, (30 * 200));
        sheet.setColumnWidth(9, (30 * 200));
        sheet.setColumnWidth(10, (30 * 200));
        sheet.setColumnWidth(11, (30 * 200));
        sheet.setColumnWidth(12, (30 * 200));
        sheet.setColumnWidth(13, (30 * 200));
        sheet.setColumnWidth(14, (30 * 200));
        sheet.setColumnWidth(15, (30 * 200));
        sheet.setColumnWidth(16, (30 * 200));
        sheet.setColumnWidth(17, (30 * 200));
        sheet.setColumnWidth(18, (30 * 200));
        sheet.setColumnWidth(19, (30 * 200));
        sheet.setColumnWidth(20, (30 * 200));
        sheet.setColumnWidth(21, (30 * 200));
        sheet.setColumnWidth(22, (30 * 200));
        sheet.setColumnWidth(23, (30 * 200));
        sheet.setColumnWidth(24, (30 * 200));
        sheet.setColumnWidth(25, (30 * 200));
        sheet.setColumnWidth(26, (30 * 200));
        sheet.setColumnWidth(27, (30 * 200));
        sheet.setColumnWidth(28, (30 * 200));
        sheet.setColumnWidth(29, (30 * 200));

        for (int i = 0; i < userListPregnantWoman.size(); i++) {
            Row row1 = sheet.createRow((i + 1));

            Log.d("UserList", String.valueOf(userListPregnantWoman.get(i).getDateVaccine16()));

            cell = row1.createCell(0);
            cell.setCellValue(userListPregnantWoman.get(i).getUID());

            cell = row1.createCell(1);
            cell.setCellValue(userListPregnantWoman.get(i).getName());

            cell = row1.createCell(2);
            cell.setCellValue(userListPregnantWoman.get(i).getDateOfBirth());

            cell = row1.createCell(3);
            cell.setCellValue(userListPregnantWoman.get(i).getBloodGroup());

            cell = row1.createCell(4);
            cell.setCellValue(userListPregnantWoman.get(i).getHusbandName());

            cell = row1.createCell(5);
            cell.setCellValue(userListPregnantWoman.get(i).getStatus());

            cell = row1.createCell(6);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine11());

            cell = row1.createCell(7);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine12());

            cell = row1.createCell(8);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine13());

            cell = row1.createCell(9);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine14());

            cell = row1.createCell(10);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine15());

            cell = row1.createCell(11);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine16());

            cell = row1.createCell(12);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine21());

            cell = row1.createCell(13);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine22());

            cell = row1.createCell(14);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine23());

            cell = row1.createCell(15);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine24());

            cell = row1.createCell(16);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine25());

            cell = row1.createCell(17);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine26());

            cell = row1.createCell(18);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine31());

            cell = row1.createCell(19);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine32());

            cell = row1.createCell(20);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine33());

            cell = row1.createCell(21);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine34());

            cell = row1.createCell(22);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine35());

            cell = row1.createCell(23);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine36());

            cell = row1.createCell(24);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine41());

            cell = row1.createCell(25);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine42());

            cell = row1.createCell(26);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine43());

            cell = row1.createCell(27);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine44());

            cell = row1.createCell(28);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine45());

            cell = row1.createCell(29);
            cell.setCellValue(userListPregnantWoman.get(i).getDateVaccine46());


            sheet.setColumnWidth(0, (30 * 200));
            sheet.setColumnWidth(1, (30 * 200));
            sheet.setColumnWidth(2, (30 * 200));
            sheet.setColumnWidth(3, (30 * 200));
            sheet.setColumnWidth(4, (30 * 200));
            sheet.setColumnWidth(5, (30 * 200));
            sheet.setColumnWidth(6, (30 * 200));
            sheet.setColumnWidth(7, (30 * 200));
            sheet.setColumnWidth(8, (30 * 200));
            sheet.setColumnWidth(9, (30 * 200));
            sheet.setColumnWidth(10, (30 * 200));
            sheet.setColumnWidth(11, (30 * 200));
            sheet.setColumnWidth(12, (30 * 200));
            sheet.setColumnWidth(13, (30 * 200));
            sheet.setColumnWidth(14, (30 * 200));
            sheet.setColumnWidth(15, (30 * 200));
            sheet.setColumnWidth(16, (30 * 200));
            sheet.setColumnWidth(17, (30 * 200));
            sheet.setColumnWidth(18, (30 * 200));
            sheet.setColumnWidth(19, (30 * 200));
            sheet.setColumnWidth(20, (30 * 200));
            sheet.setColumnWidth(21, (30 * 200));
            sheet.setColumnWidth(22, (30 * 200));
            sheet.setColumnWidth(23, (30 * 200));
            sheet.setColumnWidth(24, (30 * 200));
            sheet.setColumnWidth(25, (30 * 200));
            sheet.setColumnWidth(26, (30 * 200));
            sheet.setColumnWidth(27, (30 * 200));
            sheet.setColumnWidth(28, (30 * 200));
            sheet.setColumnWidth(29, (30 * 200));
        }


        //-----------------------------------------------------------------------------------------//
        //------------------Child Upto 5 Years-----------------------------------------------------//
        //-----------------------------------------------------------------------------------------//

        sheet = wb.createSheet("Children Upto 5");
        row = sheet.createRow(0);

        cell = row.createCell(0);
        cell.setCellValue("UID");

        cell = row.createCell(1);
        cell.setCellValue("Name");

        cell = row.createCell(2);
        cell.setCellValue("DOB");

        cell = row.createCell(3);
        cell.setCellValue("BloodGroup");

        cell = row.createCell(4);
        cell.setCellValue("MotherName");

        cell = row.createCell(5);
        cell.setCellValue("FatherName");

        cell = row.createCell(6);
        cell.setCellValue("Status");

        cell = row.createCell(7);
        cell.setCellValue("Vaccine1");

        cell = row.createCell(8);
        cell.setCellValue("Vaccine2");

        cell = row.createCell(9);
        cell.setCellValue("Vaccine3");

        cell = row.createCell(10);
        cell.setCellValue("Vaccine4");

        cell = row.createCell(11);
        cell.setCellValue("Vaccine5");

        cell = row.createCell(12);
        cell.setCellValue("Vaccine6");

        cell = row.createCell(13);
        cell.setCellValue("Vaccine7");

        cell = row.createCell(14);
        cell.setCellValue("Height");

        cell = row.createCell(15);
        cell.setCellValue("Weight");

        sheet.setColumnWidth(0, (30 * 200));
        sheet.setColumnWidth(1, (30 * 200));
        sheet.setColumnWidth(2, (30 * 200));
        sheet.setColumnWidth(3, (30 * 200));
        sheet.setColumnWidth(4, (30 * 200));
        sheet.setColumnWidth(5, (30 * 200));
        sheet.setColumnWidth(6, (30 * 200));
        sheet.setColumnWidth(7, (30 * 200));
        sheet.setColumnWidth(8, (30 * 200));
        sheet.setColumnWidth(9, (30 * 200));
        sheet.setColumnWidth(10, (30 * 200));
        sheet.setColumnWidth(11, (30 * 200));
        sheet.setColumnWidth(12, (30 * 200));
        sheet.setColumnWidth(13, (30 * 200));
        sheet.setColumnWidth(14, (30 * 200));
        sheet.setColumnWidth(15, (30 * 200));

        for (int i = 0; i < userListUpto15Years.size(); i++) {
            Row row1 = sheet.createRow((i + 1));

            cell = row1.createCell(0);
            cell.setCellValue(userListUpto15Years.get(i).getUID());

            cell = row1.createCell(1);
            cell.setCellValue(userListUpto15Years.get(i).getName());

            cell = row1.createCell(2);
            cell.setCellValue(userListUpto15Years.get(i).getDateOfBirth());

            cell = row1.createCell(3);
            cell.setCellValue(userListUpto15Years.get(i).getBloodGroup());

            cell = row1.createCell(4);
            cell.setCellValue(userListUpto15Years.get(i).getMotherName());

            cell = row1.createCell(5);
            cell.setCellValue(userListUpto15Years.get(i).getFatherName());

            cell = row1.createCell(6);
            cell.setCellValue(userListUpto15Years.get(i).getStatus());

            cell = row1.createCell(7);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine1());

            cell = row1.createCell(8);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine2());

            cell = row1.createCell(9);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine3());

            cell = row1.createCell(10);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine4());

            cell = row1.createCell(11);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine5());

            cell = row1.createCell(12);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine6());

            cell = row1.createCell(13);
            cell.setCellValue(userListUpto15Years.get(i).getDateVaccine7());

            cell = row1.createCell(14);
            cell.setCellValue(userListUpto15Years.get(i).getHeight());

            cell = row1.createCell(15);
            cell.setCellValue(userListUpto15Years.get(i).getWeight());

            sheet.setColumnWidth(0, (30 * 200));
            sheet.setColumnWidth(1, (30 * 200));
            sheet.setColumnWidth(2, (30 * 200));
            sheet.setColumnWidth(3, (30 * 200));
            sheet.setColumnWidth(4, (30 * 200));
            sheet.setColumnWidth(5, (30 * 200));
            sheet.setColumnWidth(6, (30 * 200));
            sheet.setColumnWidth(7, (30 * 200));
            sheet.setColumnWidth(8, (30 * 200));
            sheet.setColumnWidth(9, (30 * 200));
            sheet.setColumnWidth(10, (30 * 200));
            sheet.setColumnWidth(11, (30 * 200));
            sheet.setColumnWidth(12, (30 * 200));
            sheet.setColumnWidth(13, (30 * 200));
            sheet.setColumnWidth(14, (30 * 200));
            sheet.setColumnWidth(15, (30 * 200));
        }

        //-----------------------------------------------------------------------------------------//
        //-------------------------Child Upto 2 Years----------------------------------------------//
        //-----------------------------------------------------------------------------------------//

        sheet = wb.createSheet("Children Upto 2");
        row = sheet.createRow(0);

        cell = row.createCell(0);
        cell.setCellValue("UID");

        cell = row.createCell(1);
        cell.setCellValue("Name");

        cell = row.createCell(2);
        cell.setCellValue("DOB");

        cell = row.createCell(3);
        cell.setCellValue("BloodGroup");

        cell = row.createCell(4);
        cell.setCellValue("MotherName");

        cell = row.createCell(5);
        cell.setCellValue("FatherName");

        cell = row.createCell(6);
        cell.setCellValue("Status");

        cell = row.createCell(7);
        cell.setCellValue("Vaccine1");

        cell = row.createCell(8);
        cell.setCellValue("Vaccine2");

        cell = row.createCell(9);
        cell.setCellValue("Vaccine3");

        cell = row.createCell(10);
        cell.setCellValue("Vaccine4");

        cell = row.createCell(11);
        cell.setCellValue("Vaccine5");

        cell = row.createCell(12);
        cell.setCellValue("Vaccine6");

        cell = row.createCell(13);
        cell.setCellValue("Vaccine7");

        cell = row.createCell(14);
        cell.setCellValue("Vaccine8");

        cell = row.createCell(15);
        cell.setCellValue("Vaccine9");

        cell = row.createCell(16);
        cell.setCellValue("Vaccine10");

        cell = row.createCell(17);
        cell.setCellValue("Height");

        cell = row.createCell(18);
        cell.setCellValue("Weight");

        sheet.setColumnWidth(0, (30 * 200));
        sheet.setColumnWidth(1, (30 * 200));
        sheet.setColumnWidth(2, (30 * 200));
        sheet.setColumnWidth(3, (30 * 200));
        sheet.setColumnWidth(4, (30 * 200));
        sheet.setColumnWidth(5, (30 * 200));
        sheet.setColumnWidth(6, (30 * 200));
        sheet.setColumnWidth(7, (30 * 200));
        sheet.setColumnWidth(8, (30 * 200));
        sheet.setColumnWidth(9, (30 * 200));
        sheet.setColumnWidth(10, (30 * 200));
        sheet.setColumnWidth(11, (30 * 200));
        sheet.setColumnWidth(12, (30 * 200));
        sheet.setColumnWidth(13, (30 * 200));
        sheet.setColumnWidth(14, (30 * 200));
        sheet.setColumnWidth(15, (30 * 200));
        sheet.setColumnWidth(16, (30 * 200));
        sheet.setColumnWidth(17, (30 * 200));
        sheet.setColumnWidth(18, (30 * 200));

        for (int i = 0; i < userListUpto2Years.size(); i++) {
            Row row1 = sheet.createRow((i + 1));

            cell = row1.createCell(0);
            cell.setCellValue(userListUpto2Years.get(i).getUID());

            cell = row1.createCell(1);
            cell.setCellValue(userListUpto2Years.get(i).getName());

            cell = row1.createCell(2);
            cell.setCellValue(userListUpto2Years.get(i).getDateOfBirth());

            cell = row1.createCell(3);
            cell.setCellValue(userListUpto2Years.get(i).getBloodGroup());

            cell = row1.createCell(4);
            cell.setCellValue(userListUpto2Years.get(i).getMotherName());

            cell = row1.createCell(5);
            cell.setCellValue(userListUpto2Years.get(i).getFatherName());

            cell = row1.createCell(6);
            cell.setCellValue(userListUpto2Years.get(i).getStatus());

            cell = row1.createCell(7);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine0());

            cell = row1.createCell(8);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine1());

            cell = row1.createCell(9);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine2());

            cell = row1.createCell(10);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine3());

            cell = row1.createCell(11);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine4());

            cell = row1.createCell(12);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine5());

            cell = row1.createCell(13);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine6());

            cell = row1.createCell(14);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine7());

            cell = row1.createCell(15);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine8());

            cell = row1.createCell(16);
            cell.setCellValue(userListUpto2Years.get(i).getDateVaccine9());

            cell = row1.createCell(17);
            cell.setCellValue(userListUpto2Years.get(i).getHeight());

            cell = row1.createCell(18);
            cell.setCellValue(userListUpto2Years.get(i).getWeight());

            sheet.setColumnWidth(0, (30 * 200));
            sheet.setColumnWidth(1, (30 * 200));
            sheet.setColumnWidth(2, (30 * 200));
            sheet.setColumnWidth(3, (30 * 200));
            sheet.setColumnWidth(4, (30 * 200));
            sheet.setColumnWidth(5, (30 * 200));
            sheet.setColumnWidth(6, (30 * 200));
            sheet.setColumnWidth(7, (30 * 200));
            sheet.setColumnWidth(8, (30 * 200));
            sheet.setColumnWidth(9, (30 * 200));
            sheet.setColumnWidth(10, (30 * 200));
            sheet.setColumnWidth(11, (30 * 200));
            sheet.setColumnWidth(12, (30 * 200));
            sheet.setColumnWidth(13, (30 * 200));
            sheet.setColumnWidth(14, (30 * 200));
            sheet.setColumnWidth(15, (30 * 200));
            sheet.setColumnWidth(16, (30 * 200));
            sheet.setColumnWidth(17, (30 * 200));
            sheet.setColumnWidth(18, (30 * 200));
        }

        String folderName = "Import Excel";
        String fileName = folderName + System.currentTimeMillis() + ".xls";
        String path = Environment.getExternalStorageDirectory() + File.separator + folderName + File.separator + fileName;

        File file = new File(Environment.getExternalStorageDirectory() + File.separator + folderName);
        if (!file.exists()) {
            file.mkdirs();
        }

        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(path);
            wb.write(outputStream);
            // ShareViaEmail(file.getParentFile().getName(),file.getName());
            Toast.makeText(getApplicationContext(), "Excel Created in " + path, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();

            Toast.makeText(getApplicationContext(), "Not OK", Toast.LENGTH_LONG).show();
            try {
                outputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
}
