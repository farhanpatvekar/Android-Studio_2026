package com.example.demo4;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView1 = findViewById(R.id.imageView1);
        registerForContextMenu(imageView1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem saveMenuItem =  menu.add(1,1,1,"Save");
        MenuItem downloadMenuItem = menu.add(2,2,2,"Download");
        MenuItem saveAsMenuItem = menu.add(3,3,3,"Save As");
        MenuItem openImageMenuItem  = menu.add(4,4,4,"Open Image");
        MenuItem openImageAsMenuItem = menu.add(5,5,5,"Open Image As");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId){
            case 1 :
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
            case 2 :
                Toast.makeText(this, "Download", Toast.LENGTH_SHORT).show();
            case 3 :
                Toast.makeText(this, "Save As", Toast.LENGTH_SHORT).show();
            case 4 :
                Toast.makeText(this, "Open Image", Toast.LENGTH_SHORT).show();
            case 5 :
                Toast.makeText(this, "Open Image As", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        super.onContextMenuClosed(menu);
    }
}
