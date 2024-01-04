package com.hackhurricane.aashaconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;


public class Register extends AppCompatActivity {
    EditText etName, etEmail, etPassword, etBloodGroup, etMobile;
    Button btnRegister;
    TextView tvLogin;
    boolean isRegisterationValid = true;

    FirebaseAuth auth;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etBloodGroup = findViewById(R.id.etBloodGroup);
        etMobile = findViewById(R.id.etMobile);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        auth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference("Users");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
                saveData();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void signUpUser() {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString();
        String bloodGroup = etBloodGroup.getText().toString();

        if(email.isEmpty() || pass.isEmpty() || name.isEmpty() || mobile.isEmpty() || bloodGroup.isEmpty()) {
            Toast.makeText(this, "Please fill all the necessary fields", Toast.LENGTH_SHORT).show();
            isRegisterationValid = false;
            return;
        }

        if(!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            isRegisterationValid = false;
            return;
        }


        checkIfUserExists(email, etMobile.getText().toString());
    }

    private void checkIfUserExists(final String email, final String mobile) {
        dbRef.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT).show();
                    isRegisterationValid = false;
                }
                else {
                    checkIfMobileExists(mobile);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Register.this, "Database error", Toast.LENGTH_SHORT).show();
                isRegisterationValid = false;
            }
        });
    }

    private void checkIfMobileExists(final String mobile) {
        dbRef.orderByChild("mobile").equalTo(mobile).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    Toast.makeText(Register.this, "Mobile number already exists", Toast.LENGTH_SHORT).show();
                    isRegisterationValid = false;
                }
                else {
                    auth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(Register.this, task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                    isRegisterationValid = false;
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Register.this, "Database error", Toast.LENGTH_SHORT).show();
                isRegisterationValid = false;
            }
        });
    }

    private void saveData() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String bloodGroup = etBloodGroup.getText().toString();
        String mobile = etMobile.getText().toString();

        if(name.isEmpty()) {
            etName.setError("Name cannot be empty");
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email cannot be empty");
            return;
        }

        if (bloodGroup.isEmpty()) {
            etBloodGroup.setError("Blood group cannot be empty");
            return;
        }

        if (mobile.isEmpty()) {
            etMobile.setError("Mobile cannot be empty");
            return;
        }

        if(!isRegisterationValid) {
            return;
        }

        if (!isValidEmail(email)) {
            etEmail.setError("Invalid email");
            return;
        }

        int AashaID = extractAashaId(email);
        String uid = dbRef.push().getKey();
        if (uid == null) {
            Toast.makeText(this, "Database error", Toast.LENGTH_SHORT).show();
            return;
        }

        Users users = new Users(name, email, mobile,AashaID);
        dbRef.child(uid).setValue(users)
                .addOnCompleteListener(task -> Toast.makeText(Register.this, "Data saved successfully", Toast.LENGTH_SHORT).show());
    }

    private boolean isValidEmail(String email) {
        if (!email.endsWith("@aasha.com")) {
            return false;
        }

        // Extract the initial 10 characters from the email
        String initialDigits = email.substring(0, 10);

        // Check if the initial 10 characters are valid integers
        try {
            Long.parseLong(initialDigits);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int extractAashaId(String email) {
        // Extract the first 10 digits from the email (assuming the initial part is digits)
        String initialDigits = email.substring(0, 10);

        // Parse the initial digits to an integer
        try {
            return Integer.parseInt(initialDigits);
        } catch (NumberFormatException e) {
            // Handle the case where the initial digits are not a valid integer
            e.printStackTrace(); // Log the exception or handle it as per your requirement
            return 0; // Return a default value or throw an exception based on your logic
        }
    }
}
