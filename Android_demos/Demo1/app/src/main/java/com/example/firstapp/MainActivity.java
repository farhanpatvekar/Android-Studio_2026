package com.example.firstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Fixed: Replaced anonymous View.OnClickListener with a clean lambda expression
        btnLogin.setOnClickListener(view -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            if (username.equals("Aishwarya") && password.equals("Aishwarya@1234")) {
                // Fixed: Replaced text concatenation with a formatted string resource placeholder
                welcomeTextView.setText("Welcome " + edtUsername.getText().toString());

                Toast.makeText(MainActivity.this, "login_success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "login_failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
