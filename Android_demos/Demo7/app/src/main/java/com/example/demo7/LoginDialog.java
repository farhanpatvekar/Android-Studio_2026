package com.example.demo7;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {
    TextView welcomeTxtView;
    EditText edtUsername, edtPassword;
    Button btnOk, btncancel;


    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.login_actvity);
        initialization();
        setUPListener();
    }

    public void initialization ()
    {
        welcomeTxtView = findViewById(R.id.txtDialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnOk = findViewById(R.id.btnOk);
        btncancel = findViewById(R.id.btnCancel);
    }

    public void setUPListener()
    {
        btnOk.setOnClickListener(new okBtnListener());
        btncancel.setOnClickListener(new cancelBtnListener());
    }

    class okBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                            "Ok",
                            Toast.LENGTH_LONG)
                    .show();
            dismiss();
        }
    }
    static class cancelBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),
                    "Cancel",
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
}
