package com.example.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    EditText editTextMin, editTextMax;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMax = findViewById(R.id.editTextMax);
        editTextMin = findViewById(R.id.editTextMin);
        textView = findViewById(R.id.textViewResultado);
    }

    public void sorteia(View v)
    {
        int min, max;
        min = Integer.parseInt(editTextMin.getText().toString());
        max = Integer.parseInt(editTextMax.getText().toString());
        if(max < min)
        {
            textView.setText("Valores Incompatíveis");
        }
        else if(min == max)
        {
            textView.setText(Integer.toString(min));
        }
        else
        {
            int result = new Random().nextInt(max - min) + min;
            textView.setText(Integer.toString(result));
        }

    }
}