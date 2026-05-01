package com.omkar.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLinear = findViewById(R.id.btnLinear);
        Button btnRelative = findViewById(R.id.btnRelative);
        Button btnTable = findViewById(R.id.btnTable);
        Button btnFrame = findViewById(R.id.btnFrame);

        btnLinear.setOnClickListener(v ->
                startActivity(new Intent(this, LinearActivity.class)));

        btnRelative.setOnClickListener(v ->
                startActivity(new Intent(this, RelativeActivity.class)));

        btnTable.setOnClickListener(v ->
                startActivity(new Intent(this, TableActivity.class)));

        btnFrame.setOnClickListener(v ->
                startActivity(new Intent(this, FrameActivity.class)));
    }
}
