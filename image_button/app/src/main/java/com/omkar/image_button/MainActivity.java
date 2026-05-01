package com.omkar.image_button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button img,check,radio,toggle,spinner,alert,rating,progress,toast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        img=findViewById(R.id.btnImageButton);
        check=findViewById(R.id.btnCheckBox);
        radio=findViewById(R.id.btnRadio);
        toggle=findViewById(R.id.btnToggle);
        spinner=findViewById(R.id.btnSpinner);
        alert=findViewById(R.id.btnAlert);
        rating=findViewById(R.id.btnRating);
        progress=findViewById(R.id.btnProgress);
        toast=findViewById(R.id.btnToast);



        img.setOnClickListener(v ->
                startActivity(new Intent(this, ImageButtonActivity.class)));

        check.setOnClickListener(v ->
                startActivity(new Intent(this, CheckBoxActivity.class)));

        radio.setOnClickListener(v ->
                startActivity(new Intent(this, RadioActivity.class)));

        toggle.setOnClickListener(v ->
                startActivity(new Intent(this, ToggleActivity.class)));

        spinner.setOnClickListener(v ->
                startActivity(new Intent(this, SpinnerActivity.class)));

        alert.setOnClickListener(v ->
                startActivity(new Intent(this, AlertActivity.class)));

        rating.setOnClickListener(v ->
                startActivity(new Intent(this, RatingActivity.class)));

        progress.setOnClickListener(v ->
                startActivity(new Intent(this, ProgressActivity.class)));

        toast.setOnClickListener(v ->
                startActivity(new Intent(this, ToastActivity.class)));

    }
}