package com.omkar.image_button;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_check_box);


        c1=findViewById(R.id.check1);
        c2=findViewById(R.id.check2);
        c3=findViewById(R.id.check3);
        c4=findViewById(R.id.check4);

        button=findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String result="Selected:\n";

                if(c1.isChecked())
                    result+="Mobile Technology\n";

                if(c2.isChecked())
                    result+="Artificial Intelligence\n";

                if(c3.isChecked())
                    result+="Data Science\n";

                if(c4.isChecked())
                    result+="Cloud Computing\n";


                Toast.makeText(CheckBoxActivity.this,result,Toast.LENGTH_LONG).show();

            }
        });

    }
}