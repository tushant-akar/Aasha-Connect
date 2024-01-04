package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChildUpto15 extends AppCompatActivity {

    public static final String EXTRA_UID = "com.hackhurricane.aashaconnect.extra.UID";
    ListView list;
    FloatingActionButton addNew;

    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    DBHandlerUpto15Years handler = new DBHandlerUpto15Years(this,"Upto15Years",null,1);

//    String arr1[]={"Bruce Wayne","Clark Kent","Hal Jordan","Barry Allen","Wally West","Lex Luthor","John Jones","John Watson","Sherlock Holmes","Thomas Wayne","Mycroft Holmes","Greg Lestrade","Harry Potter","Severus Snape","Albus Dumbledpre","Emiway James"};
//    String arr2[]={"31-05-2003","21-11-2020","21-11-2020","17-12-2022","21-11-2020","21-11-2020","21-11-2020","21-11-2020","31-04-2020","12-10-2003","21-11-2020","21-11-2020","21-11-2020","17-12-2022","21-11-2020","21-11-2020"};
//    Date dob[]=new Date[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_upto15);

        Object[] returnedArrays = handler.RetrieveAllDetailsUpto15Years();
        int[] UID = (int[]) returnedArrays[0];
        String[] name = (String[]) returnedArrays[1];
        String[] DOB = (String[]) returnedArrays[2];
        Date dob[]=new Date[handler.getSizeUpto15Years()];

        list=findViewById(R.id.list_view);
        addNew=findViewById(R.id.Add_New);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChildUpto15.this, "This will add new entries", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), NewEntry_Upto15Years.class));
            }
        });

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

//        CustomNameAdapter N = new CustomNameAdapter(this,R.layout.activity_name_list_adapter,arr1,dob);
//        list.setAdapter(N);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ChildUpto15.this, "You clicked on : "+arr1[position], Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(),From_15Yrs.class).putExtra(EXTRA_NAME,arr1[position]));
//            }
//        });

        CustomNameAdapter N = new CustomNameAdapter(this,R.layout.activity_name_list_adapter,name,UID);
        list.setAdapter(N);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChildUpto15.this, "You clicked on : "+name[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Form_15Yrs.class);
                Bundle extras = new Bundle();
                extras.putInt(EXTRA_UID,UID[position]);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}