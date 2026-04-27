package com.example.coffeeapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button loginBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        auth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(v -> {

            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if(userEmail.isEmpty() || userPassword.isEmpty()){
                Toast.makeText(LoginActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            auth.signInWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}