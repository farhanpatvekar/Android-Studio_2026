package com.example.machine_task_dialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements NameActivity.OnTextDialogClickListener {

    EditText edtName;
    Button btnNameDialog;
    TextView txtNamedDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnNameDialog = findViewById(R.id.btnNameDialog);
        txtNamedDisplay = findViewById(R.id.txtNameDisplay);

        btnNameDialog.setOnClickListener(view -> {

            String textPass = edtName.getText().toString();

            NameActivity dialog =
                    new NameActivity(MainActivity.this,
                            textPass,
                            MainActivity.this);

            dialog.show();
        });
    }

    @Override
    public void onSuccess(String editedText) {
        txtNamedDisplay.setText(editedText);
    }

    @Override
    public void onFailure() {

    }
}