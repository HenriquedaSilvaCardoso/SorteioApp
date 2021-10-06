package com.example.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Random;

public class MainActivity extends Activity {

    EditText editTextMin, editTextMax;
    TextView textView;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMax = findViewById(R.id.editTextMax);
        editTextMin = findViewById(R.id.editTextMin);
        textView = findViewById(R.id.textViewResultado);
        button = findViewById(R.id.button);

        editTextMin.addTextChangedListener(numberTextWatcher);
        editTextMax.addTextChangedListener(numberTextWatcher);
    }

    public void sorteia(View v)
    {
        button = findViewById(R.id.button);
        int min, max;
        min = Integer.parseInt(editTextMin.getText().toString());
        max = Integer.parseInt(editTextMax.getText().toString());

        if(max < min)
        {
            Context context = getApplicationContext();
            CharSequence text = "Valores Incompatíveis";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            int result = new Random().nextInt((max + 1) - min) + min ;
            textView.setText(Integer.toString(result));
        }
    }

    private TextWatcher numberTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String minNumberInput = editTextMin.getText().toString().trim();
            String maxNumberInput = editTextMax.getText().toString().trim();

            button.setEnabled(!minNumberInput.isEmpty() && !maxNumberInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}