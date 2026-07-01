package com.example.demo5;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView txtViewDialogs;
    Button btnAlertDialog, btnDatePickerDialog, btnTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtViewDialogs = findViewById(R.id.textViewDialogs);
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePicker);
        btnDatePickerDialog = findViewById(R.id.btnDatePicker);

        btnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());

        btnDatePickerDialog.setOnClickListener(new BtnDatePickerDialogListener());

        btnTimePickerDialog.setOnClickListener(new BtnTimePickerDialogListener());
    }


    public class BtnDatePickerDialogListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    new DatePickerDialogClickListener(),
                    2026,
                    5,
                    9
            );
            datePickerDialog.show();
        }
    }

    public static class DatePickerDialogClickListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Log.e("Tag", "i : "+ i + " i1 : "+ i1 + " i2 : "+ i2);
        }
    }

    public class BtnTimePickerDialogListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            Log.e("tag", "i : "+ i + " i1 : "+i1);
                        }
                    },
                    12,
                    20,
                    true
                    );
            timePickerDialog.show();
        }
    }
    public class BtnAlertDialogClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder alertDiaogBuilder =
                    new AlertDialog.Builder(MainActivity.this);

            alertDiaogBuilder.setIcon(R.drawable.ic_launcher_background);
            alertDiaogBuilder.setTitle("Exam Submission");
            alertDiaogBuilder.setMessage("Do you really want to submit the Exam?");
//            alertDiaogBuilder.setPositiveButton("Yes", new DialogPositiveButtonClicked());
//            alertDiaogBuilder.setNegativeButton("No", new DialogNegativeButtonClicked());
//            alertDiaogBuilder.setNeutralButton("Cancel", new DialogNeutralButtonClicked());

            alertDiaogBuilder.setPositiveButton("Yes", new AlertDialogClickListener() );
            alertDiaogBuilder.setNegativeButton("No", new AlertDialogClickListener());
            alertDiaogBuilder.setNeutralButton("Neutral", new AlertDialogClickListener());

            AlertDialog alertDialog = alertDiaogBuilder.create();
            alertDialog.show();
        }
    }


    public class AlertDialogClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            switch (i){
                case -1:
                    Toast.makeText(MainActivity.this, "Yes clicked " + i, Toast.LENGTH_SHORT).show();
                case -2:
                    Toast.makeText(MainActivity.this, "No clicked " + i, Toast.LENGTH_SHORT).show();
                case -3:
                    Toast.makeText(MainActivity.this, "Neutral clicked " + i, Toast.LENGTH_SHORT).show();
            }
        }
    }


//    public class DialogPositiveButtonClicked implements DialogInterface.OnClickListener {
//
//        @Override
//        public void onClick(DialogInterface dialogInterface, int i) {
//            Toast.makeText(MainActivity.this, "Yes Button Clicked : " + i, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public class DialogNegativeButtonClicked implements DialogInterface.OnClickListener {
//        @Override
//        public void onClick(DialogInterface dialogInterface, int i) {
//            Toast.makeText(MainActivity.this, "No Button Clicked : " + i, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public class DialogNeutralButtonClicked implements DialogInterface.OnClickListener {
//        @Override
//        public void onClick(DialogInterface dialogInterface, int i) {
//            Toast.makeText(MainActivity.this, "Neutral Button Clicked : " + i, Toast.LENGTH_LONG).show();
//        }
//    }
}