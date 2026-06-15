package com.example.assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity  {

    TextView txtName, txtPhoneNO, txtEmail, txtAddress, txtCollageName, txtTechName, txtYearOfPassing;
    EditText edtName, edtPhoneNO, edtEmail, edtAddress, edtCollageName, edtTechName, edtYearOfPassing;
    ShapeableImageView imageView;
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
//        Textview defining
        txtName = findViewById(R.id.Name);
        txtPhoneNO = findViewById(R.id.phoneNo);
        txtEmail = findViewById(R.id.Email);
        txtAddress = findViewById(R.id.Address);
        txtCollageName = findViewById(R.id.collageCompany);
        txtTechName = findViewById(R.id.techName);
        txtYearOfPassing = findViewById(R.id.yearOfPassing);

//        EditView defining
        edtName = findViewById(R.id.edtName);
        edtPhoneNO = findViewById(R.id.etdPhone);
        edtEmail = findViewById(R.id.etdEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtCollageName = findViewById(R.id.edtCollage);
        edtTechName = findViewById(R.id.edtTech);
        edtYearOfPassing = findViewById(R.id.edtYearOfPass);

        btnSubmit = findViewById(R.id.btnSubmit);



    }



}