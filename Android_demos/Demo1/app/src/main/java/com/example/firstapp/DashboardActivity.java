package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView welcomeTextView;
    EditText edtPassword,edtUsername;
    Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dashboard_activity);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        View.OnClickListener listner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtUsername.getText().toString().equals("Bitcode") &&
                        (edtPassword.getText().toString().equals("Bitcode@1234"))){
                    Toast.makeText(DashboardActivity.this,
                            "login Success!",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DashboardActivity.this,
                            "Login UnSucessful!",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
        btnLogin.setOnClickListener(listner);
    }
}
