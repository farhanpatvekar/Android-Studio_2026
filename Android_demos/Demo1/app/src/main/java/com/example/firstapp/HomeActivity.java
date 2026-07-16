package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView welcomeTextView;
    EditText edtUsername,edtPassword;

    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(edtUsername.getText().toString().equals("Bitcode") && (edtPassword.getText().toString().equals("BitCode@1234"))){
            Toast.makeText(this,"Login Success", Toast.LENGTH_LONG);
        }else{
            Toast.makeText(this, "Login Unsucessful", Toast.LENGTH_LONG);
        }

    }

}
