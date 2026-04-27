package com.example.eventhandling;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnClick, btnLongClick;
    TextView txtTouch;
    EditText editKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);
        btnLongClick = findViewById(R.id.btnLongClick);
        txtTouch = findViewById(R.id.txtTouch);
        editKey = findViewById(R.id.editKey);

        // 1. OnClickListener
        btnClick.setOnClickListener(v ->
                Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        );

        // 2. OnLongClickListener
        btnLongClick.setOnLongClickListener(v -> {
            Toast.makeText(this, "Long Press Detected", Toast.LENGTH_SHORT).show();
            return true; // important
        });

        // 3. OnTouchListener
        txtTouch.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(this, "Screen Touched", Toast.LENGTH_SHORT).show();
            }
            return true;
        });

        // 4. OnKeyListener
        editKey.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                Toast.makeText(this, "Key Pressed: " + keyCode, Toast.LENGTH_SHORT).show();
            }
            return false;
        });
    }
}
