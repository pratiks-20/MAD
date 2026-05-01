package com.omkar.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSMS, btnCall, btnSettings, btnNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSMS = findViewById(R.id.btnSMS);
        btnCall = findViewById(R.id.btnCall);
        btnSettings = findViewById(R.id.btnSettings);
        btnNetwork = findViewById(R.id.btnNetwork);

        // SMS Intent
        btnSMS.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:7058571655"));
            intent.putExtra("sms_body", "Hello from Omkar App");
            startActivity(intent);
        });

        // Call Intent
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        // Settings Intent
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        });

        // Network Details
        btnNetwork.setOnClickListener(v -> {

            TelephonyManager tm =
                    (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

            String network = tm.getNetworkOperatorName();

            Toast.makeText(MainActivity.this,
                    "Network: " + network,
                    Toast.LENGTH_LONG).show();
        });

    }
}