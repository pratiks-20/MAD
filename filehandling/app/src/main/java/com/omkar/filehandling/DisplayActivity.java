package com.omkar.filehandling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.io.FileInputStream;

public class DisplayActivity extends AppCompatActivity {

    TableLayout tableLayout;
    String fileName = "users.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tableLayout = findViewById(R.id.tableLayout);

        try {
            FileInputStream fis = openFileInput(fileName);
            int c;
            String data = "";

            while ((c = fis.read()) != -1) {
                data += Character.toString((char) c);
            }
            fis.close();

            String[] rows = data.split("\n");

            // TABLE HEADER
            addRow("Name", "Email", "Phone");

            for (String row : rows) {
                String[] cols = row.split(",");
                if (cols.length == 3) {
                    addRow(cols[0], cols[1], cols[2]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addRow(String col1, String col2, String col3) {
        TableRow tr = new TableRow(this);

        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        TextView tv3 = new TextView(this);

        tv1.setText(col1);
        tv2.setText(col2);
        tv3.setText(col3);

        tv1.setPadding(10,10,10,10);
        tv2.setPadding(10,10,10,10);
        tv3.setPadding(10,10,10,10);

        tr.addView(tv1);
        tr.addView(tv2);
        tr.addView(tv3);

        tableLayout.addView(tr);
    }
}