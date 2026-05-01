package com.omkar.layoutsapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    String items[] = {
            "Android",
            "Java",
            "Python",
            "C++",
            "Kotlin",
            "Flutter",
            "React Native"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        ArrayAdapter adapter =
                new ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        items
                );

        listView.setAdapter(adapter);
    }
}
