package com.example.assignment_4_dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.awt.font.TextAttribute;

public class AddContactDialog extends Dialog {


    Button dismissBtn,nextBtn;
    EditText contactNameEditText,contactNumberEditText;

    String cName;
    int cNumber;

    public interface CreateAddcontactDialog {

        void success();
        void fail();

    }

    CreateAddcontactDialog createAddcontactDialog;

    public void setAddcontactDialog(CreateAddcontactDialog createAddcontactDialog){
        this.createAddcontactDialog=createAddcontactDialog;
    }

    public AddContactDialog(@NonNull Context context) {

        super(context);
        setContentView(R.layout.addcontact);
        initViews();
        attachListner();
    }

    public void initViews(){
        dismissBtn=findViewById(R.id.dimissBtn);
        nextBtn=findViewById(R.id.nextBtn);
        contactNameEditText=findViewById(R.id.nameEditText);
        contactNumberEditText=findViewById(R.id.numberEditText);
    }

    public void attachListner(){

        dismissBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAddcontactDialog.fail();
                dismiss();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAddcontactDialog.success();
                dismiss();
            }
        });
    }

    public String getContactNumberEditText() {

        return contactNumberEditText.getText().toString();
    }
    public String getContactNameEditText() {
        return contactNameEditText.getText().toString();
    }
}