package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ShapeableImageView homeImage;
    Button btnApple, btnSamSung, btnVivo, btnOppo;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        homeImage = findViewById(R.id.homeImage);
        btnApple = findViewById(R.id.btnApple);
        btnSamSung = findViewById(R.id.btnSamSung);
        btnOppo = findViewById(R.id.btnOppo);
        btnVivo = findViewById(R.id.btnVivo);

        btnApple.setOnClickListener(this);
        btnSamSung.setOnClickListener(this);
        btnVivo.setOnClickListener(this);
        btnOppo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        if(view.getId() == (R.id.btnApple)){
            i.putExtra("id",view.getId());
        } else if (view.getId() == (R.id.btnSamSung)) {
            i.putExtra("id", view.getId());
        } else if (view.getId() == (R.id.btnVivo)) {
            i.putExtra("id", view.getId());
        } else if (view.getId() == (R.id.btnOppo)) {
            i.putExtra("id", view.getId());
        }
//        startActivity(i);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        assert data != null;
        Bundle bundle = data.getExtras();
        assert bundle != null;
        image = bundle.getInt("Image",-1);

        homeImage.setImageResource(image);
    }
}