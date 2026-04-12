package com.example.filehandling;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button saveBtn, readBtn;
    TextView result;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        saveBtn = findViewById(R.id.saveBtn);
        readBtn = findViewById(R.id.readBtn);
        result = findViewById(R.id.result);

        // SAVE DATA
        saveBtn.setOnClickListener(v -> {
            try {
                String data = editText.getText().toString();

                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                result.setText("Saved Successfully ✅");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // READ DATA
        readBtn.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);

                int c;
                String temp = "";

                while ((c = fis.read()) != -1) {
                    temp += (char) c;
                }

                fis.close();
                result.setText(temp);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
