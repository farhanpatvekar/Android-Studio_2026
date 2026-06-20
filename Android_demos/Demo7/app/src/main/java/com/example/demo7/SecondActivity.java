package com.example.demo7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnCustomDialogWay2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        btnCustomDialogWay2 = findViewById(R.id.btnCustomDialogWay2);
        btnCustomDialogWay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialog loginDialog1 = new LoginDialog(SecondActivity.this);
                loginDialog1.show();
            }
        });
    }
}
