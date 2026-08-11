package com.example.fitnexa2;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnCreate;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnCreate=findViewById(R.id.btnCreate);

        mAuth=FirebaseAuth.getInstance();

        btnCreate.setOnClickListener(v -> {

            String email=etEmail.getText().toString().trim();
            String password=etPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                etEmail.setError("Enter Email");
                return;
            }

            if(TextUtils.isEmpty(password)){
                etPassword.setError("Enter Password");
                return;
            }

            if(password.length()<6){
                etPassword.setError("Password should be at least 6 characters");
                return;
            }

            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()){

                            mAuth.signOut();

                            new AlertDialog.Builder(SignupActivity.this)
                                    .setTitle("Success")
                                    .setMessage("Your account created successfully.")
                                    .setCancelable(false)
                                    .setPositiveButton("OK",(dialog,which)->{

                                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                                        finish();

                                    }).show();

                        }else{

                            Toast.makeText(SignupActivity.this,
                                    task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();

                        }

                    });

        });

    }
}