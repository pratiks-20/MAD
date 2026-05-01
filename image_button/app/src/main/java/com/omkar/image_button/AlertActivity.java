package com.omkar.image_button;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlertActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this);

            builder.setMessage("Close App?")
                    .setPositiveButton("Yes",
                            (dialog, id) -> finish())

                    .setNegativeButton("No",
                            (dialog, id) -> dialog.cancel());

            builder.show();

        });

    }
}