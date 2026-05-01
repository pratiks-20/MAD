package com.omkar.camera_seek_bar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCamera, btnSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        btnSeekbar = findViewById(R.id.btnSeekbar);

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, cameraActivity.class);
            startActivity(intent);
        });

        btnSeekbar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
            startActivity(intent);
        });
    }
}