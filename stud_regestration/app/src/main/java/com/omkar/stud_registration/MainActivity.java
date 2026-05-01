package com.omkar.stud_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, roll, course;
    Button register;
    ListView listView;

    ArrayList<String> studentList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        roll = findViewById(R.id.etRoll);
        course = findViewById(R.id.etCourse);
        register = findViewById(R.id.btnRegister);
        listView = findViewById(R.id.listView);

        studentList = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        listView.setAdapter(adapter);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = name.getText().toString();
                String r = roll.getText().toString();
                String c = course.getText().toString();

                String data =
                        "Name: " + n +
                                "\nRoll: " + r +
                                "\nCourse: " + c;

                studentList.add(data);

                adapter.notifyDataSetChanged();

                name.setText("");
                roll.setText("");
                course.setText("");

            }
        });

    }
}