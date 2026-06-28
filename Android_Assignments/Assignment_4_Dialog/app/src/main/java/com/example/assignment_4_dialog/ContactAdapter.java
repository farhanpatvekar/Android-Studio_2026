package com.example.assignment_4_dialog;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    ArrayList<Contact> contactArrayList;

    public ContactAdapter(ArrayList<Contact> contactArrayList){

        this.contactArrayList=contactArrayList;

    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list,
                parent,
                false

        );

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        Contact contact=contactArrayList.get(position);

        holder.contactName.setText(contact.getContactName());
        holder.contactNumber.setText(""+contact.getContactNumber());

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

}
