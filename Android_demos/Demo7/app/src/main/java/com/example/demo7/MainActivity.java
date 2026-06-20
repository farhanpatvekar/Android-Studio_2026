package com.example.demo7;

import android.app.Dialog;
import android.app.TaskInfo;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnDialogWay1, btnDialogWay2, btnDialogWay3, btnOk, btnCancel;
    EditText edtUsername, edtPassword;
    Dialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnDialogWay1 = findViewById(R.id.btnDialogWay1);
        btnDialogWay2 = findViewById(R.id.btnDialogWay2);
        btnDialogWay3 = findViewById(R.id.btnDialogWay3);

        btnDialogWay1.setOnClickListener(new MyBtnCustomDialogWay1ClickListener());
    }

    public class MyBtnCustomDialogWay1ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            loginDialog = new Dialog(MainActivity.this);
            loginDialog.setContentView(R.layout.login_actvity);
            edtUsername = loginDialog.findViewById(R.id.edtUsername);
            edtPassword = loginDialog.findViewById(R.id.edtPassword);
            btnOk = loginDialog.findViewById(R.id.btnOk);
            btnCancel = loginDialog.findViewById(R.id.btnCancel);

            loginDialog.show();

            btnOk.setOnClickListener(new MyBtnOkClickListener());
            btnCancel.setOnClickListener(new MyBtnCancelClickListener());
        }
    }

    public class MyBtnOkClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Ok Clicked", Toast.LENGTH_LONG)
                    .show();
            loginDialog.dismiss();
        }
    }

    public class MyBtnCancelClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Cancel Clicked",
                    Toast.LENGTH_LONG).show();
            loginDialog.dismiss();
        }
    }
}