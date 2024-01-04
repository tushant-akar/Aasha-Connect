package com.hackhurricane.aashaconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChildUpto2 extends AppCompatActivity {
    public static final String EXTRA_UID = "com.hackhurricane.aashaconnect.extra.UID";

    ListView list;
    FloatingActionButton addNew;
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    DBHandlerUpto2Years handler = new DBHandlerUpto2Years(this,"Upto2Years",null,1);

//    String arr1[]={"Shrimohan Tripathi","Trisha Banerjee","Aman Singh Thakur","Sanskriti Gupta","Soham Nandi","Divyansh Singhal","Nehal Jain","Harsh Bhadauria","Nishi Jain","Rambabu Malgaya"};
//    String arr2[]={"31-05-2003","21-11-2024","21-11-2020","17-12-2022","21-11-2020","21-11-2020","21-11-2020","21-11-2020","31-04-2020","12-10-2003"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_upto2);

        Object[] returnedArrays = handler.RetrieveAllDetailsUpto2Years();
        int[] UID = (int[]) returnedArrays[0];
        String[] name = (String[]) returnedArrays[1];
        String[] DOB = (String[]) returnedArrays[2];
        Date dob[]=new Date[handler.getSizeUpto2Years()];

        list=findViewById(R.id.list_view);
        addNew=findViewById(R.id.Add_New);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChildUpto2.this, "This will add new entries", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NewEntry_Upto2Years.class));
            }
        });

        for (int i = 0; i < DOB.length; i++) {
            try {
                dob[i]= format.parse(DOB[i]);
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
//                Toast.makeText(ChildUpto2.this, "You clicked on : "+name[position], Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(),Form_2Yrs.class);
//                Bundle extras = new Bundle();
//                extras.putString(EXTRA_NAME,name[position]);
//                extras.putString(EXTRA_DOB, String.valueOf(UID[position]));
//                intent.putExtras(extras);
//                startActivity(intent);
//            }
//        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChildUpto2.this, "You clicked on : "+name[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Form_2Yrs.class);
                Bundle extras = new Bundle();
//                extras.putString(EXTRA_UID, String.valueOf(UID[position]));
                extras.putInt(EXTRA_UID,UID[position]);
                intent.putExtras(extras);
                startActivity(intent);
//                startActivity(new Intent(getApplicationContext(),Form_2Yrs.class).putExtras(extras));
            }
        });
    }
}