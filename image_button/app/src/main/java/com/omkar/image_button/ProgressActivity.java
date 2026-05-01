package com.omkar.image_button;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progressBar = findViewById(R.id.progress);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> startProgress());

    }

    private void startProgress()
    {

        Handler handler = new Handler();

        new Thread(() -> {

            while(progress <= 100)
            {

                handler.post(() -> progressBar.setProgress(progress));

                progress++;

                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }

        }).start();

    }
}