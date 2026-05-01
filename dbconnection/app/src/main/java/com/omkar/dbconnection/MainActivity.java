package com.omkar.dbconnection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone;
    Button saveBtn;

    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        saveBtn = findViewById(R.id.saveBtn);

        database = FirebaseDatabase.getInstance().getReference("users");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString().trim();
                String e = email.getText().toString().trim();
                String p = phone.getText().toString().trim();

                if (n.isEmpty() || e.isEmpty() || p.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                String id = database.push().getKey();

                User user = new User(n, e, p);

                database.child(id).setValue(user)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(MainActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();

                            name.setText("");
                            email.setText("");
                            phone.setText("");
                        })
                        .addOnFailureListener(e1 -> {
                            Toast.makeText(MainActivity.this, "Failed: " + e1.getMessage(), Toast.LENGTH_LONG).show();
                        });
            }
        });
    }
}