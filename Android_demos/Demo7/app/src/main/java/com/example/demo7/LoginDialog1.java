package com.example.demo7;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginDialog1 extends Dialog {
    TextView welcomeTxtView;
    EditText edtUsername, edtPassword;
    Button btnOk, btnCancel;

    public interface OnLoginDialogClickListener{
        void onSuccess();
        void onFailure();
    }

    public LoginDialog1(Context context){
        super(context);
        initView();
        setUpListener();
    }

    public OnLoginDialogClickListener onLoginDialogClickListener;

    public void initView(){

        setContentView(R.layout.login_actvity);
        welcomeTxtView = findViewById(R.id.txtDialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void setOnLoginDialogClickListener(OnLoginDialogClickListener onLoginDialogClickListener){
        this.onLoginDialogClickListener = onLoginDialogClickListener;
    }

    public void setUpListener(){
        btnOk.setOnClickListener(new MyBtnOkClickListener());
        btnCancel.setOnClickListener(new MyBtnCancelClickListener());
    }

    class MyBtnOkClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            onLoginDialogClickListener.onSuccess();
            dismiss();
        }
    }

    class MyBtnCancelClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            onLoginDialogClickListener.onFailure();
            dismiss();
        }
    }
}
