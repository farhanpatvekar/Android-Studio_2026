package com.example.demo4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "onCreateOptionsMenu method called", Toast.LENGTH_LONG).show();
        MenuItem historyMenuItem = menu.add(1,1,1,"History");
//        MenuItem settingsMenuItem = menu.add(2,2,2,"Settings");

        SubMenu settingsSubMenu = menu.addSubMenu(2,2,2,"Settings");
        settingsSubMenu.add(3,2,2,"Phone Settings");
        settingsSubMenu.add(4,2,2,"Bluetooth Settings");
        settingsSubMenu.add(5,2,2,"Display Settings");
        MenuItem TranslateMenuItem = menu.add(6,3,3,"Translate");
        MenuItem downloadsMenuItem = menu.add(7,4,4,"Downloads");
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "onPrepareOptionsMenu method called", Toast.LENGTH_LONG).show();

        menu.findItem(2);
        menu.getItem(3);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case 1 :
                Toast.makeText(this, "History Item selected", Toast.LENGTH_SHORT).show();
            case 2 :
                Toast.makeText(this, "Settings Item selected", Toast.LENGTH_SHORT).show();
            case 3 :
                Toast.makeText(this, "Translate Item selected", Toast.LENGTH_SHORT).show();
            case 4 :
                Toast.makeText(this, "Downloads Item selected", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(this, "onOptionsMenuClosed method called", Toast.LENGTH_SHORT).show();
        menu.close();
        super.onOptionsMenuClosed(menu);
    }
}