package com.example.firstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTextView;
    EditText edtUsername, edtPassword;
    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

//way 2 - creating object of anonymous class
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().equals("Aishwarya") &&
                        (edtPassword.getText().toString().equals("Aishwarya@1234"))) {
                    welcomeTextView.setText("Welcome " + edtUsername.getText().toString());
                    Toast.makeText(SecondActivity.this,
                            "Login Success!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SecondActivity.this
                            , "Login Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}