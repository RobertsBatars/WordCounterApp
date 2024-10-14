package com.example.wordcounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MainActivity class handles the UI interactions and events.
 */
public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerOption;
    private Button buttonCount;
    private TextView textViewResult;

    private String selectedOption = "Words"; // Default option

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextInput = findViewById(R.id.editTextInput);
        spinnerOption = findViewById(R.id.spinnerOption);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOption.setAdapter(adapter);

        spinnerOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selectedOption = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

        // Set up the Button click event
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editTextInput.getText().toString();

                // Validate input text
                if (inputText.trim().isEmpty()) {
                    // Show warning using Toast
                    Toast.makeText(MainActivity.this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show();
                } else {
                    // Perform counting in com.example.wordcounterapp.CountUtils class
                    if (selectedOption.equals("Words")) {
                        int wordCount = CountUtils.countWords(inputText);
                        textViewResult.setText(getString(R.string.result_words, wordCount));
                    } else {
                        int charCount = CountUtils.countCharacters(inputText);
                        textViewResult.setText(getString(R.string.result_characters, charCount));
                    }
                }
            }
        });
    }
}