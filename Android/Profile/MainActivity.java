// Vertical project: ProfileActivity.java
package com.example.vertical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button backButton = findViewById(R.id.btnBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName(
                        "com.example.explicit_intent",
                        "com.example.explicit_intent.MainActivity"
                );
                startActivity(i);

                // Optional: finish this activity so user cannot press back to return here
                finish();
            }
        });
    }
}