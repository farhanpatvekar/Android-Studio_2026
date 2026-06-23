package com.example.progressingdialog;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnOpenProgressDialog;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnOpenProgressDialog = findViewById(R.id.btnOpenProgressDialog);

        btnOpenProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] fileUrls = {
                        "fileUrl1",
                        "fileUrl2",
                        "fileUrl3",
                        "fileUrl4"
                };
                new Downloader().execute(fileUrls);
            }
        });
    }

    class Downloader extends AsyncTask<String, Integer, Float> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Progress of File Download");
            progressDialog.setMessage("File downloading.....");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }

        @Override
        protected Float doInBackground(String... fileUrls) {

            for (String fileUrl : fileUrls) {
                for (int i = 0; i < 100; i++) {
                    Log.e("tag",fileUrl+ " -- " + i + "%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Integer[] progress = new Integer[1];
                    progress[0] = i;
                    publishProgress(i);
                    progressDialog.setProgress(i);
                }
            }
            return 10.3f;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e("tag","Progress " + values[0]);
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Float aFloat) {
            super.onPostExecute(aFloat);
            Log.e("tag","Result " + aFloat);
        }
    }
}