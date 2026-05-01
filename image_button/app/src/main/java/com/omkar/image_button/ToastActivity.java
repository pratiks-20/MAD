package com.omkar.image_button;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toast);

        Toast.makeText(this,
                "Welcome to Android",
                Toast.LENGTH_LONG).show();

    }
}