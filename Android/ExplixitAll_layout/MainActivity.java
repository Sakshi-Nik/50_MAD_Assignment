package com.example.explicitall_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button HorizontalButton, VerticalButton, RelativeButton,
            TableButton, FrameButton, ListButton,
            AbsoluteButton, ConstraintButton, GridButton,
            CalculatorButton, BchangeButton, ProfileButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        HorizontalButton = findViewById(R.id.horizontal);
        VerticalButton = findViewById(R.id.Vertical);
        RelativeButton = findViewById(R.id.Relative);
        TableButton = findViewById(R.id.Table);
        FrameButton = findViewById(R.id.Frame);
        ListButton = findViewById(R.id.List);
        AbsoluteButton = findViewById(R.id.Absolute);
        ConstraintButton = findViewById(R.id.Constraint);
        GridButton = findViewById(R.id.grid);
        CalculatorButton = findViewById(R.id.calculator);
        BchangeButton = findViewById(R.id.Bchange);
        ProfileButton = findViewById(R.id.profile);

        // Set click listeners
        HorizontalButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.horizontal",
                    "com.example.horizontal.MainActivity");
            startActivity(i);
        });

        VerticalButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.verticallayout",
                    "com.example.verticallayout.MainActivity");
            startActivity(i);
        });

        RelativeButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.relativelayout",
                    "com.example.relativelayout.MainActivity");
            startActivity(i);
        });

        TableButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.tablelayout",
                    "com.example.tablelayout.MainActivity");
            startActivity(i);
        });

        FrameButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.framelayout",
                    "com.example.framelayout.MainActivity");
            startActivity(i);
        });

        ListButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.listviewlayout",
                    "com.example.listviewlayout.MainActivity");
            startActivity(i);
        });

        AbsoluteButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.absolutelayout",
                    "com.example.absolutelayout.MainActivity");
            startActivity(i);
        });

        ConstraintButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.buttonimage",
                    "com.example.buttonimage.MainActivity");
            startActivity(i);
        });

        GridButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.gridlayout",
                    "com.example.gridlayout.MainActivity");
            startActivity(i);
        });
        CalculatorButton.setOnClickListener( v ->{
            Intent i = new Intent();
            i.setClassName("com.example.calculator",
                    "com.example.calculator.MainActivity");
            startActivity(i);
        });


        BchangeButton.setOnClickListener( v ->{
            Intent i = new Intent();
            i.setClassName("com.example.buttonimage",
                    "com.example.buttonimage.MainActivity");
            startActivity(i);
        });


        ProfileButton.setOnClickListener(v -> {
            Intent i = new Intent();
            i.setClassName("com.example.vertical",
                    "com.example.vertical.MainActivity");
            startActivity(i);
        });


    }
}