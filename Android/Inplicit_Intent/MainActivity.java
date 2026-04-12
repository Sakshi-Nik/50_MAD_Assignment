package com.example.intent;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.provider.MediaStore;


public class MainActivity extends AppCompatActivity {

    Button whatsapp, contact,facebook,camera;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsapp=findViewById(R.id.button);
        contact=findViewById(R.id.button2);
        facebook=findViewById(R.id.button3);
        camera=findViewById(R.id.button4);

        //whatsapp
        whatsapp.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(android.net.Uri.parse("https://wa.me/7219219422"));
            startActivity(i);
        });

        contact.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(android.net.Uri.parse("content://contacts/people/"));
            startActivity(i);
        });

        // Facebook
        facebook.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(android.net.Uri.parse("https://www.facebook.com/"));
            startActivity(i);
        });

        // Camera
        camera.setOnClickListener(v -> {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(i);
        });
    }
}

