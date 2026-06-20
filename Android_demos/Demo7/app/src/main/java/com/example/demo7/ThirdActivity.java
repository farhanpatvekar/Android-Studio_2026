package com.example.demo7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    Button btnCustomDialogWay3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        btnCustomDialogWay3 = findViewById(R.id.customDialogWay3);

        btnCustomDialogWay3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginDialog1 loginDialogWay3 = new LoginDialog1(ThirdActivity.this);
                        loginDialogWay3.setOnLoginDialogClickListener(new MyLoginDialogClickListener());
                        loginDialogWay3.show();
                    }
                }
        );

    }

    static class MyLoginDialogClickListener implements LoginDialog1.OnLoginDialogClickListener{

        @Override
        public void onSuccess() {
            Log.e("tag","inside third activity, login successful!");
        }

        @Override
        public void onFailure() {
            Log.e("tag","inside third activity, login unsuccessful!");
        }
    }
    }

