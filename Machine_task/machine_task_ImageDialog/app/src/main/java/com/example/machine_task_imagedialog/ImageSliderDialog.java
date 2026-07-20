package com.example.machine_task_imagedialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import com.google.android.material.imageview.ShapeableImageView;

public class ImageSliderDialog extends Dialog {

    ShapeableImageView imageContainer;
    Button btnClose;
    private onImageClickDialog listener;
    int delayReceived, currentIndex = 0;
    boolean repeatRequest;
    int[] imageArrayReceived;

    public interface onImageClickDialog {
        void onFailure();
    }

    public ImageSliderDialog(Context context, int[] imageArray, int delay, Boolean repeat, onImageClickDialog listener) {
        super(context);
        this.imageArrayReceived = imageArray;
        this.delayReceived = delay;
        this.repeatRequest  = repeat;
        this.listener = listener;
        setContentView(R.layout.imagesliderdialog);
        initViews();
        imageDisplay();
    }

    public void initViews() {
        imageContainer = findViewById(R.id.imageContainer);
        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new onClickCancelButton());
    }

    public void imageDisplay() {
        imageContainer.setImageResource(imageArrayReceived[currentIndex]);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                imageContainer.setImageResource(imageArrayReceived[currentIndex]);
                currentIndex++;

                if(currentIndex < imageArrayReceived.length) {
                    handler.postDelayed(this, delayReceived);
                } else if (repeatRequest) {
                    currentIndex = 0;
                    handler.postDelayed(this, delayReceived);
                }
            }
        };

        handler.post(runnable);
    }


    public class onClickCancelButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
                listener.onFailure();
                dismiss();
        }
    }
}
