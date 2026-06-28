package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class SecondActivity extends AppCompatActivity {

    ShapeableImageView imageOne, imageTwo, imageThree, imageFour;
    int btnId, image1,image2, image3, image4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imageOne = findViewById(R.id.imageOne);
        imageTwo = findViewById(R.id.imageTwo);
        imageThree = findViewById(R.id.imageThree);
        imageFour = findViewById(R.id.imageFour);


        extractData();

    }

    public void extractData(){
        Intent intent = getIntent();
        btnId = intent.getIntExtra("id", -1);

        if(btnId == R.id.btnApple){
            image1 = R.drawable.apple1;
            image2 = R.drawable.apple2;
            image3 = R.drawable.apple3;
            image4 = R.drawable.apple4;
        } else if (btnId == R.id.btnSamSung) {
            image1 = R.drawable.samsung1;
            image2 = R.drawable.sasung2;
            image3 = R.drawable.samnsung3;
            image4 = R.drawable.samsung4;
        } else if (btnId == R.id.btnVivo) {
            image1 = R.drawable.vivo1;
            image2 = R.drawable.vivo2;
            image3 = R.drawable.vivo3;
            image4 = R.drawable.vivo4;
        } else if (btnId == R.id.btnOppo) {
            image1 = R.drawable.oppo1;
            image2 = R.drawable.oppo2;
            image3 = R.drawable.oppo3;
            image4 = R.drawable.oppo4;
        }

        imageOne.setImageResource(image1);
        imageTwo.setImageResource(image2);
        imageThree.setImageResource(image3);
        imageFour.setImageResource(image4);

        imageOne.setOnClickListener( v -> ImageSend(image1));
        imageTwo.setOnClickListener(v -> ImageSend(image2));
        imageThree.setOnClickListener(v -> ImageSend(image3));
        imageFour.setOnClickListener(v -> ImageSend(image4));
    }


    public void ImageSend(int imageRef) {
        Intent i = new Intent();
        i.putExtra("Image", imageRef);
        setResult(-1,i);
        finish();
    }
}
