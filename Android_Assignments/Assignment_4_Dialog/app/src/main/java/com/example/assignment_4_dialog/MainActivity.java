package com.example.assignment_4_dialog;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addContactBtn;

    RecyclerView contactRecylerView;
    ContactAdapter contactAdapter;
    ArrayList<Contact> contactArrayList;

    int contactNumber;
    String contactName;

    AddContactDialog addContactDialog;
    EditText contactNameEditText,contactNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initContactList();
        initView();
        attachListner();
    }

    public void initContactList(){

        contactArrayList=new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            contactArrayList.add(new Contact("contact"+i,
                    "8762349825"+i
            ));
        }
    }

    public void initView(){

        addContactBtn = findViewById(R.id.addContactBtn);
        contactRecylerView=findViewById(R.id.contactRecyclerView);
        contactAdapter = new ContactAdapter(contactArrayList);
        contactRecylerView.setAdapter(contactAdapter);
        contactRecylerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));

        contactNameEditText=findViewById(R.id.nameEditText);
        contactNumberEditText=findViewById(R.id.numberEditText);

    }
    public void attachListner() {

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContactDialog=new AddContactDialog(MainActivity.this);
                addContactDialog.setAddcontactDialog(new AddContactDialogListner());
                addContactDialog.show();
            }
        });
    }
    public class AddContactDialogListner implements AddContactDialog.CreateAddcontactDialog{


        @Override
        public void success() {
            Contact contact=new Contact(addContactDialog.getContactNameEditText(), addContactDialog.getContactNumberEditText());
            contactArrayList.add(contact);
            contactAdapter.notifyDataSetChanged();

        }

        @Override
        public void fail() {

            Toast.makeText(MainActivity.this,
                    "cannot add contact!",
                    Toast.LENGTH_LONG).show();
        }
    }
}