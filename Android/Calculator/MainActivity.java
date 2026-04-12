package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText InputNoFirst, InputNoSecond;
    Button add, sub, mul, div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputNoFirst = findViewById(R.id.num1EditText);
        InputNoSecond = findViewById(R.id.num2EditText);

        add = findViewById(R.id.addButton);
        sub = findViewById(R.id.subButton);
        mul = findViewById(R.id.mulButton);
        div = findViewById(R.id.divButton);

        result = findViewById(R.id.resultTextView);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });
    }


    private void calculate(String operator){
        String num1Str = InputNoFirst.getText().toString();
        String num2Str = InputNoSecond.getText().toString();

        if(num1Str.isEmpty() || num2Str.isEmpty()){
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double res = 0;

        switch (operator){
            case "+":
                res = num1 + num2; break;
            case "-":
                res = num1 - num2; break;
            case "*":
                res = num1 * num2; break;
            case "/":
                if(num2 == 0){
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = num1 / num2;
                break;
        }

        result.setText("Result: " + res);
    }
}