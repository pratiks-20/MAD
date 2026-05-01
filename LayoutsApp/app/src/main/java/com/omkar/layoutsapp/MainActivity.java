package com.omkar.layoutsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button constraint, absolute, grid, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraint = findViewById(R.id.btnConstraint);
        absolute = findViewById(R.id.btnAbsolute);
        grid = findViewById(R.id.btnGrid);
        list = findViewById(R.id.btnList);

        constraint.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ConstraintActivity.class)));

        absolute.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AbsoluteActivity.class)));

        grid.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GridActivity.class)));

        list.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListActivity.class)));

    }
}
