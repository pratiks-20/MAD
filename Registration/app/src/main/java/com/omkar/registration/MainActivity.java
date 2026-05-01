package com.omkar.registration;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    Button btnDate, btnSubmit, btnDelete;
    TextView tvDate, tvResult;

    String selectedDate = "";
    String fileName = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnDate = findViewById(R.id.btnDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDelete = findViewById(R.id.btnDelete);
        tvDate = findViewById(R.id.tvDate);
        tvResult = findViewById(R.id.tvResult);

        loadData(); // load existing data

        // Date Picker
        btnDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            new DatePickerDialog(this, (view, y, m, d) -> {
                selectedDate = d + "/" + (m + 1) + "/" + y;
                tvDate.setText("DOB: " + selectedDate);
            },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            ).show();
        });

        // SAVE DATA
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || selectedDate.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String time = new SimpleDateFormat(
                    "dd/MM/yyyy HH:mm:ss",
                    Locale.getDefault()
            ).format(Calendar.getInstance().getTime());

            String data = "Name: " + name +
                    "\nEmail: " + email +
                    "\nPhone: " + phone +
                    "\nDOB: " + selectedDate +
                    "\nTime: " + time +
                    "\n----------------------\n";

            saveData(data);
            loadData();
        });

        // DELETE DATA
        btnDelete.setOnClickListener(v -> {
            deleteData();
        });
    }

    // SAVE
    private void saveData(String data) {
        try {
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOAD
    private void loadData() {
        try {
            FileInputStream fis = openFileInput(fileName);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();

            String text = new String(buffer);
            tvResult.setText(text);

        } catch (Exception e) {
            tvResult.setText("No Data Found");
        }
    }

    // DELETE
    private void deleteData() {
        deleteFile(fileName);
        tvResult.setText("");
        Toast.makeText(this, "All Data Deleted", Toast.LENGTH_SHORT).show();
    }
}