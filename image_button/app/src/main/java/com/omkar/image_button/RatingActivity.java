package com.omkar.image_button;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {

    RatingBar r;
    Button b;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        r = findViewById(R.id.ratingBar);
        b = findViewById(R.id.button);

        b.setOnClickListener(v ->

                Toast.makeText(this,
                        String.valueOf(r.getRating()),
                        Toast.LENGTH_SHORT).show()

        );

    }
}