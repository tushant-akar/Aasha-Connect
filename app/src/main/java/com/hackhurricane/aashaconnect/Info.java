package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;


public class Info extends AppCompatActivity {

    Button dangerSign;
    Button dietPlans;
    Button familyPlanning;
    Button healthFacilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        dangerSign = findViewById(R.id.idealANC);
        dietPlans = findViewById(R.id.firstANC);
        familyPlanning = findViewById(R.id.secondANC);
        healthFacilities = findViewById(R.id.fourthANC);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.info);

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

        dangerSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DangerSigns.class));
            }
        });

        dietPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DietPlan.class));
            }
        });

        familyPlanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FamilyPlanning.class));
            }
        });

        healthFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HealthFacilities.class));
            }
        });

    }
}
