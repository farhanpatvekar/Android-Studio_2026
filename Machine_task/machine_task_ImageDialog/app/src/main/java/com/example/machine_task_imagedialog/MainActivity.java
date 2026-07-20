package com.example.machine_task_imagedialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements ImageSliderDialog.onImageClickDialog{

    Button btnOpenImageDialog;
    int[] imageArray = {R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image5
    };
    int delay = 2000;
    Boolean repeat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenImageDialog = findViewById(R.id.btnOpenImageDialog);

        btnOpenImageDialog.setOnClickListener(view -> {
            ImageSliderDialog imageSliderDialog = new ImageSliderDialog(MainActivity.this,
                    imageArray,
                    delay,
                    repeat,
                    MainActivity.this);

            imageSliderDialog.show();
        });
    }

    @Override
    public void onFailure() {

    }
}
