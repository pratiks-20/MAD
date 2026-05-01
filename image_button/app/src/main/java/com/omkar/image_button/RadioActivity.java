package com.omkar.image_button;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioActivity extends AppCompatActivity {

    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        rg = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int selectedId = rg.getCheckedRadioButtonId();

                RadioButton rb = findViewById(selectedId);

                Toast.makeText(RadioActivity.this,
                        rb.getText(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}