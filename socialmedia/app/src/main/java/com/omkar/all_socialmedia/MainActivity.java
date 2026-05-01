package com.omkar.all_socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button whatsapp, instagram, facebook, youtube, twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsapp = findViewById(R.id.btnWhatsapp);
        instagram = findViewById(R.id.btnInstagram);
        facebook = findViewById(R.id.btnFacebook);
        youtube = findViewById(R.id.btnYoutube);
        twitter = findViewById(R.id.btnTwitter);


        whatsapp.setOnClickListener(v ->
                openApp("https://wa.me/")
        );

        instagram.setOnClickListener(v ->
                openApp("https://www.instagram.com/")
        );

        facebook.setOnClickListener(v ->
                openApp("https://www.facebook.com/")
        );

        youtube.setOnClickListener(v ->
                openApp("https://www.youtube.com/")
        );

        twitter.setOnClickListener(v ->
                openApp("https://twitter.com/")
        );

    }


    public void openApp(String url)
    {

        try {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

        }
        catch (Exception e)
        {

            Toast.makeText(this,
                    "App not installed",
                    Toast.LENGTH_SHORT).show();

        }

    }

}