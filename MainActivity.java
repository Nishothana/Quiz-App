package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answersGroup;
    private Button submitButton;
    private String correctAnswer = "Paris"; // The correct answer

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        questionText = findViewById(R.id.question_text);
        answersGroup = findViewById(R.id.answers_group);
        submitButton = findViewById(R.id.submit_button);

        // Ensure views are properly initialized
        if (questionText == null || answersGroup == null || submitButton == null) {
            throw new RuntimeException("Failed to initialize views");
        }

        // Set up the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected RadioButton
                int selectedId = answersGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton != null) {
                        // Get the text of the selected RadioButton
                        String selectedAnswer = selectedRadioButton.getText().toString();

                        // Check if the selected answer is correct
                        if (selectedAnswer.equals(correctAnswer)) {
                            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Incorrect. Try again!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Error in finding selected RadioButton", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
