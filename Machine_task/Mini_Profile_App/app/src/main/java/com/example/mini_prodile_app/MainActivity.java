package com.example.mini_prodile_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    TextView txtName, txtAge, txtWelcome;
    Button btnSave, btnDisplay, btnClear;
    private final String key1 = "key1", key2 = "key2", preference = "prf";
    String getKey1, getKey2, nameCheck;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(preference, Context.MODE_PRIVATE);
        editor = sp.edit();
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        txtWelcome = findViewById(R.id.txtWelcome);
        btnSave = findViewById(R.id.btnSave);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnClear = findViewById(R.id.btnClear);


        txtName.setText(R.string.name);
        txtAge.setText(R.string.age);

        btnSave.setOnClickListener(view -> {

            if (edtName.getText().toString().isEmpty() || edtAge.getText().toString().isEmpty()){
                Toast.makeText(this, "Please fill your name and age!", Toast.LENGTH_SHORT).show();
            } else
            {
            editor.putString(key1, edtName.getText().toString());
            editor.putString(key2, edtAge.getText().toString());
            editor.apply();
            txtWelcome.setText("Welcome " + sp.getString(key1, edtName.getText().toString()) + "!");
            Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnDisplay.setOnClickListener(view -> {
            getKey1 = sp.getString(key1, edtName.getText().toString());
            getKey2 = sp.getString(key2, edtAge.getText().toString());
            if (getKey1.isEmpty() && getKey2.isEmpty()) {
                Toast.makeText(this, "Nothing to display", Toast.LENGTH_SHORT).show();
            } else {
                txtName.setText("Name : " + getKey1);
                txtAge.setText("Age : " + getKey2);

            }
        });

        btnClear.setOnClickListener(view -> {
            txtName.setText(R.string.name);
            txtAge.setText(R.string.age);
            txtWelcome.setText("");
            edtName.setText("");
            edtAge.setText("");
            editor.clear();
            editor.apply();
        });
        nameCheck = sp.getString(key1, edtName.getText().toString());
        if (nameCheck.isEmpty()) {
            txtWelcome.setText("Welcome!");
        } else {
            txtWelcome.setText("Welcome back " + nameCheck);
        }
    }

}
