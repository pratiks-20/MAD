package com.omkar.image_button;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ToggleActivity extends AppCompatActivity {

    ToggleButton toggle;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        toggle = findViewById(R.id.toggleButton);
        text = findViewById(R.id.textView);

    }

    public void onToggleClick(View view)
    {

        if(toggle.isChecked())

            text.setText("Toggle is ON");

        else

            text.setText("Toggle is OFF");

    }
}