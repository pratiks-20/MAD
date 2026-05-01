package com.omkar.filehandling;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone;
    Button saveBtn, viewBtn;

    String fileName = "users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        saveBtn = findViewById(R.id.saveBtn);
        viewBtn = findViewById(R.id.viewBtn);

        // SAVE DATA
        saveBtn.setOnClickListener(v -> {
            String data = name.getText().toString() + "," +
                    email.getText().toString() + "," +
                    phone.getText().toString() + "\n";

            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_APPEND);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "User Saved", Toast.LENGTH_SHORT).show();

                name.setText("");
                email.setText("");
                phone.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // OPEN DISPLAY ACTIVITY
        viewBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            startActivity(intent);
        });
    }
}