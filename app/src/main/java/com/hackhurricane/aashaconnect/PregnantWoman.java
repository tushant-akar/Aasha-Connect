package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class PregnantWoman extends AppCompatActivity {
//    public static final String EXTRA_NAME = "com.example.aasha.extra.NAME";
    public static final String EXTRA_UID = "com.example.aasha.extra.UID";

    private DBHandlerPregnantWoman  dbHandlerPregnantWomanExcel;

    ListView list;
    FloatingActionButton addNew;
    Button export;
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//    ArrayList<classPregnantWoman> userList;


    
    DBHandlerPregnantWoman handler = new DBHandlerPregnantWoman(this,"PregnantWomanData",null,1);

//    String name[]={"Rahul","Anfinsen Joseph","Alex","Mickhel","Reena","Gerin","Ishaan","Gautam","Gaurav","Mayank Chobey","Soya","Mansi","Virendra","Ananya","Kashif","Yathyarth"};
//    String DOB[]={"31-05-2003","21-11-2020","21-11-2020","17-12-2022","21-11-2020","21-11-2020","21-11-2020","21-11-2020","31-04-2020","12-10-2003","21-11-2020","21-11-2020","21-11-2020","17-12-2022","21-11-2020","21-11-2020"};
//    Date dob[]=new Date[50];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant_woman);

//        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
//        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
//        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");


        Object[] returnedArrays = handler.RetrieveAllDetailsPregnantWomanData();
        int[] UID = (int[]) returnedArrays[0];
        String[] name = (String[]) returnedArrays[1];
        String[] DOB = (String[]) returnedArrays[2];
        Date dob[]=new Date[handler.getSizePregnantWomanData()];
        Log.d("UID Tag New", Arrays.toString(UID));

        list=findViewById(R.id.list_view);
        addNew=findViewById(R.id.Add_New);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PregnantWoman.this, "This will add new entries", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NewEntry_PregnantWoman.class));
            }
        });

//        export.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
//                    if (getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
//                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//                        requestPermissions(permissions, 1);
//                    } else {
//                        importData();
//                    }
//                } else {
//                    importData();
//                }
//            }
//        });

        for (int i = 0; i < DOB.length; i++) {
            try {
                dob[i]=format.parse(DOB[i]);
            } catch (ParseException e) {
                Toast.makeText(this, "ERROR Date Format", Toast.LENGTH_SHORT).show();
            }
        }

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

        CustomNameAdapter N = new CustomNameAdapter(this,R.layout.activity_name_list_adapter,name,UID);
        list.setAdapter(N);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(PregnantWoman.this, "You clicked on : "+name[position], Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(),Form_2Yrs.class).putExtra(EXTRA_NAME,name[position]));
//            }
//        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PregnantWoman.this, "You clicked on : "+name[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),PregnantWomanDetail.class);
                Bundle extras = new Bundle();
//                extras.putString(EXTRA_UID, String.valueOf(UID[position]));
                extras.putInt(EXTRA_UID,UID[position]);
                intent.putExtras(extras);
                startActivity(intent);
//                startActivity(new Intent(getApplicationContext(),Form_2Yrs.class).putExtras(extras));
            }
        });
    }

//    private void importData() {
////        try{
////        userList = dbHandlerPregnantWomanExcel.getAllUserForExcel();
//        userList=handler.getAllUserForExcel();
////        }catch (Exception E){
////            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
////        }
//        if(userList.size()>0){
//            createXLFile();
//        }else{
//            Toast.makeText(this, "Empty List", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void createXLFile(){
//        Workbook wb = new HSSFWorkbook();
//
//        Cell cell = null;
//        Sheet sheet = null;
//        sheet = wb.createSheet("Pregnant Woman Data");
//        Row row = sheet.createRow(0);
//
//        cell = row.createCell(0);
//        cell.setCellValue("UID");
//
//        cell = row.createCell(1);
//        cell.setCellValue("Name");
//
//        cell = row.createCell(2);
//        cell.setCellValue("DOB");
//
//        cell = row.createCell(3);
//        cell.setCellValue("BloodGroup");
//
//        cell = row.createCell(4);
//        cell.setCellValue("HusbandName");
//
//        cell = row.createCell(5);
//        cell.setCellValue("Status");
//
//        cell = row.createCell(6);
//        cell.setCellValue("Vaccine11");
//
//        cell = row.createCell(7);
//        cell.setCellValue("Vaccine12");
//
//        cell = row.createCell(8);
//        cell.setCellValue("Vaccine13");
//
//        cell = row.createCell(9);
//        cell.setCellValue("Vaccine14");
//
//        cell = row.createCell(10);
//        cell.setCellValue("Vaccine15");
//
//        cell = row.createCell(11);
//        cell.setCellValue("Vaccine16");
//
//        cell = row.createCell(12);
//        cell.setCellValue("Vaccine21");
//
//        cell = row.createCell(13);
//        cell.setCellValue("Vaccine22");
//
//        cell = row.createCell(14);
//        cell.setCellValue("Vaccine23");
//
//        cell = row.createCell(15);
//        cell.setCellValue("Vaccine24");
//
//        cell = row.createCell(16);
//        cell.setCellValue("Vaccine25");
//
//        cell = row.createCell(17);
//        cell.setCellValue("Vaccine26");
//
//        cell = row.createCell(18);
//        cell.setCellValue("Vaccine31");
//
//        cell = row.createCell(19);
//        cell.setCellValue("Vaccine32");
//
//        cell = row.createCell(20);
//        cell.setCellValue("Vaccine33");
//
//        cell = row.createCell(21);
//        cell.setCellValue("Vaccine34");
//
//        cell = row.createCell(22);
//        cell.setCellValue("Vaccine35");
//
//        cell = row.createCell(23);
//        cell.setCellValue("Vaccine36");
//
//        cell = row.createCell(24);
//        cell.setCellValue("Vaccine41");
//
//        cell = row.createCell(25);
//        cell.setCellValue("Vaccine42");
//
//        cell = row.createCell(26);
//        cell.setCellValue("Vaccine43");
//
//        cell = row.createCell(27);
//        cell.setCellValue("Vaccine44");
//
//        cell = row.createCell(28);
//        cell.setCellValue("Vaccine45");
//
//        cell = row.createCell(29);
//        cell.setCellValue("Vaccine46");
//
//        sheet.setColumnWidth(0, (30 * 200));
//        sheet.setColumnWidth(1, (30 * 200));
//        sheet.setColumnWidth(2, (30 * 200));
//        sheet.setColumnWidth(3, (30 * 200));
//        sheet.setColumnWidth(4, (30 * 200));
//        sheet.setColumnWidth(5, (30 * 200));
//        sheet.setColumnWidth(6, (30 * 200));
//        sheet.setColumnWidth(7, (30 * 200));
//        sheet.setColumnWidth(8, (30 * 200));
//        sheet.setColumnWidth(9, (30 * 200));
//        sheet.setColumnWidth(10, (30 * 200));
//        sheet.setColumnWidth(11, (30 * 200));
//        sheet.setColumnWidth(12, (30 * 200));
//        sheet.setColumnWidth(13, (30 * 200));
//        sheet.setColumnWidth(14, (30 * 200));
//        sheet.setColumnWidth(15, (30 * 200));
//        sheet.setColumnWidth(16, (30 * 200));
//        sheet.setColumnWidth(17, (30 * 200));
//        sheet.setColumnWidth(18, (30 * 200));
//        sheet.setColumnWidth(19, (30 * 200));
//        sheet.setColumnWidth(20, (30 * 200));
//        sheet.setColumnWidth(21, (30 * 200));
//        sheet.setColumnWidth(22, (30 * 200));
//        sheet.setColumnWidth(23, (30 * 200));
//        sheet.setColumnWidth(24, (30 * 200));
//        sheet.setColumnWidth(25, (30 * 200));
//        sheet.setColumnWidth(26, (30 * 200));
//        sheet.setColumnWidth(27, (30 * 200));
//        sheet.setColumnWidth(28, (30 * 200));
//        sheet.setColumnWidth(29, (30 * 200));
//
//        for (int i = 0; i < userList.size(); i++) {
//            Row row1 = sheet.createRow((i + 1));
//
//            Log.d("UserList", String.valueOf(userList.get(i).getDateVaccine16()));
//
//            cell = row1.createCell(0);
//            cell.setCellValue(userList.get(i).getUID());
//
//            cell = row1.createCell(1);
//            cell.setCellValue(userList.get(i).getName());
//
//            cell = row1.createCell(2);
//            cell.setCellValue(userList.get(i).getDateOfBirth());
//
//            cell = row1.createCell(3);
//            cell.setCellValue(userList.get(i).getBloodGroup());
//
//            cell = row1.createCell(4);
//            cell.setCellValue(userList.get(i).getHusbandName());
//
//            cell = row1.createCell(5);
//            cell.setCellValue(userList.get(i).getStatus());
//
//            cell = row1.createCell(6);
//            cell.setCellValue(userList.get(i).getDateVaccine11());
//
//            cell = row1.createCell(7);
//            cell.setCellValue(userList.get(i).getDateVaccine12());
//
//            cell = row1.createCell(8);
//            cell.setCellValue(userList.get(i).getDateVaccine13());
//
//            cell = row1.createCell(9);
//            cell.setCellValue(userList.get(i).getDateVaccine14());
//
//            cell = row1.createCell(10);
//            cell.setCellValue(userList.get(i).getDateVaccine15());
//
//            cell = row1.createCell(11);
//            cell.setCellValue(userList.get(i).getDateVaccine16());
//
//            cell = row1.createCell(12);
//            cell.setCellValue(userList.get(i).getDateVaccine21());
//
//            cell = row1.createCell(13);
//            cell.setCellValue(userList.get(i).getDateVaccine22());
//
//            cell = row1.createCell(14);
//            cell.setCellValue(userList.get(i).getDateVaccine23());
//
//            cell = row1.createCell(15);
//            cell.setCellValue(userList.get(i).getDateVaccine24());
//
//            cell = row1.createCell(16);
//            cell.setCellValue(userList.get(i).getDateVaccine25());
//
//            cell = row1.createCell(17);
//            cell.setCellValue(userList.get(i).getDateVaccine26());
//
//            cell = row1.createCell(18);
//            cell.setCellValue(userList.get(i).getDateVaccine31());
//
//            cell = row1.createCell(19);
//            cell.setCellValue(userList.get(i).getDateVaccine32());
//
//            cell = row1.createCell(20);
//            cell.setCellValue(userList.get(i).getDateVaccine33());
//
//            cell = row1.createCell(21);
//            cell.setCellValue(userList.get(i).getDateVaccine34());
//
//            cell = row1.createCell(22);
//            cell.setCellValue(userList.get(i).getDateVaccine35());
//
//            cell = row1.createCell(23);
//            cell.setCellValue(userList.get(i).getDateVaccine36());
//
//            cell = row1.createCell(24);
//            cell.setCellValue(userList.get(i).getDateVaccine41());
//
//            cell = row1.createCell(25);
//            cell.setCellValue(userList.get(i).getDateVaccine42());
//
//            cell = row1.createCell(26);
//            cell.setCellValue(userList.get(i).getDateVaccine43());
//
//            cell = row1.createCell(27);
//            cell.setCellValue(userList.get(i).getDateVaccine44());
//
//            cell = row1.createCell(28);
//            cell.setCellValue(userList.get(i).getDateVaccine45());
//
//            cell = row1.createCell(29);
//            cell.setCellValue(userList.get(i).getDateVaccine46());
//
//
//            sheet.setColumnWidth(0, (30 * 200));
//            sheet.setColumnWidth(1, (30 * 200));
//            sheet.setColumnWidth(2, (30 * 200));
//            sheet.setColumnWidth(3, (30 * 200));
//            sheet.setColumnWidth(4, (30 * 200));
//            sheet.setColumnWidth(5, (30 * 200));
//            sheet.setColumnWidth(6, (30 * 200));
//            sheet.setColumnWidth(7, (30 * 200));
//            sheet.setColumnWidth(8, (30 * 200));
//            sheet.setColumnWidth(9, (30 * 200));
//            sheet.setColumnWidth(10, (30 * 200));
//            sheet.setColumnWidth(11, (30 * 200));
//            sheet.setColumnWidth(12, (30 * 200));
//            sheet.setColumnWidth(13, (30 * 200));
//            sheet.setColumnWidth(14, (30 * 200));
//            sheet.setColumnWidth(15, (30 * 200));
//            sheet.setColumnWidth(16, (30 * 200));
//            sheet.setColumnWidth(17, (30 * 200));
//            sheet.setColumnWidth(18, (30 * 200));
//            sheet.setColumnWidth(19, (30 * 200));
//            sheet.setColumnWidth(20, (30 * 200));
//            sheet.setColumnWidth(21, (30 * 200));
//            sheet.setColumnWidth(22, (30 * 200));
//            sheet.setColumnWidth(23, (30 * 200));
//            sheet.setColumnWidth(24, (30 * 200));
//            sheet.setColumnWidth(25, (30 * 200));
//            sheet.setColumnWidth(26, (30 * 200));
//            sheet.setColumnWidth(27, (30 * 200));
//            sheet.setColumnWidth(28, (30 * 200));
//            sheet.setColumnWidth(29, (30 * 200));
//        }
//
//        String folderName = "Import Excel";
//        String fileName = folderName + System.currentTimeMillis() + ".xls";
//        String path = Environment.getExternalStorageDirectory() + File.separator + folderName + File.separator + fileName;
//
//        File file = new File(Environment.getExternalStorageDirectory() + File.separator + folderName);
//        if (!file.exists()) {
//           file.mkdirs();
//        }
//
//        FileOutputStream outputStream = null;
//
//        try {
//            outputStream = new FileOutputStream(path);
//            wb.write(outputStream);
//            // ShareViaEmail(file.getParentFile().getName(),file.getName());
//            Toast.makeText(getApplicationContext(), "Excel Created in " + path, Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//            Toast.makeText(getApplicationContext(), "Not OK", Toast.LENGTH_LONG).show();
//            try {
//                outputStream.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//
//            }
//        }
//    }
}