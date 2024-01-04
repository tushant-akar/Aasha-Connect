package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText uid;
    EditText password;
    TextView tvRedirectSignUp;
    Button logIn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uid = findViewById(R.id.UserID);
        password = findViewById(R.id.Password);
        tvRedirectSignUp = findViewById(R.id.tvRegister);
        logIn = findViewById(R.id.buttonLogin);
        auth = FirebaseAuth.getInstance();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tvRedirectSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void login() {
        String email = uid.getText().toString();
        String pass = password.getText().toString();
        if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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