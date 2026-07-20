package com.example.machine_task_dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class NameActivity extends Dialog {

    private String textPass;

    EditText txtName;
    RadioButton radioUpperCase, radioLowerCase;
    CheckBox checkReverse;
    Button onSave, onCancel;

    private OnTextDialogClickListener listener;

    public interface OnTextDialogClickListener {
        void onSuccess(String editedText);
        void onFailure();
    }

    public NameActivity(Context context, String textPass,
                        OnTextDialogClickListener listener) {
        super(context);

        this.textPass = textPass;
        this.listener = listener;

        setContentView(R.layout.name_activity);

        initViews();
        setUpListener();
    }

    private void initViews() {
        txtName = findViewById(R.id.txtName);
        radioUpperCase = findViewById(R.id.radioUpperCase);
        radioLowerCase = findViewById(R.id.radioLowerCase);
        checkReverse = findViewById(R.id.checkReverse);
        onSave = findViewById(R.id.onSave);
        onCancel = findViewById(R.id.onCancel);

        txtName.setText(textPass);
    }

    private void setUpListener() {
        onSave.setOnClickListener(new SaveBtnOnClickListener());
        onCancel.setOnClickListener(new CancelBtnOnClickListener());
    }

    public class SaveBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String text = txtName.getText().toString();

            if (radioUpperCase.isChecked()) {
                text = text.toUpperCase();
            }

            if (radioLowerCase.isChecked()) {
                text = text.toLowerCase();
            }

            if (checkReverse.isChecked()) {
                text = new StringBuilder(text).reverse().toString();
            }

            listener.onSuccess(text);
            dismiss();
        }
    }

    public class CancelBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            listener.onFailure();
            dismiss();
        }
    }
}
