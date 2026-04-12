package com.example.inputcontrols;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    RadioGroup radioGender;
    RadioButton selectedGender;

    CheckBox cbJava, cbPython;
    Spinner spinnerCourse;
    ToggleButton toggleHostel;

    RatingBar ratingBar;

    ProgressBar progressBar1, progressBar2;

    Button btnSubmit;
    ImageButton imgButton;

    String[] courses = {"Select Course", "BCA", "BBA", "BTech", "BA","B.Com","B.Sc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        radioGender = findViewById(R.id.radioGender);

        cbJava = findViewById(R.id.cbJava);
        cbPython = findViewById(R.id.cbPython);

        spinnerCourse = findViewById(R.id.spCourse);
        toggleHostel = findViewById(R.id.toggleHostel);

        ratingBar = findViewById(R.id.ratingBar);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);

        btnSubmit = findViewById(R.id.btnSubmit);
//        imgButton = findViewById(R.id.imgButton);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        courses);

        spinnerCourse.setAdapter(adapter);

        progressBar2.setVisibility(View.INVISIBLE);

        View.OnClickListener submitAction = v -> showAlertDialog();

        btnSubmit.setOnClickListener(submitAction);
//        imgButton.setOnClickListener(submitAction);
    }

    private void showAlertDialog() {

        progressBar2.setVisibility(View.VISIBLE);
        progressBar1.setProgress(50);

        String name = editName.getText().toString();

        int selectedId = radioGender.getCheckedRadioButtonId();

        if (selectedId != -1)
            selectedGender = findViewById(selectedId);

        String gender = selectedGender != null ?
                selectedGender.getText().toString() : "Not Selected";

        String skills = "";

        if (cbJava.isChecked())
            skills += "Java ";

        if (cbPython.isChecked())
            skills += "Python ";

        String course = spinnerCourse.getSelectedItem().toString();

        String hostel =
                toggleHostel.isChecked() ? "Yes" : "No";

        float rating = ratingBar.getRating();

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Confirm Submission");

        builder.setMessage(
                "Name: " + name +
                        "\nGender: " + gender +
                        "\nSkills: " + skills +
                        "\nCourse: " + course +
                        "\nHostel Required: " + hostel +
                        "\nRating: " + rating
        );

        builder.setPositiveButton("Submit", (dialog, which) -> {

            progressBar1.setProgress(100);

            Toast.makeText(MainActivity.this,
                    "Form Submitted Successfully",
                    Toast.LENGTH_LONG).show();

            progressBar2.setVisibility(View.INVISIBLE);
        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }
}