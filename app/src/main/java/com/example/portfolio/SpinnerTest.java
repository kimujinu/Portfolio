package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerTest extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    String[] items = {"버스커버스커","김나롱","찌뽀","니뽀"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_test);

        textView = findViewById(R.id.textView5);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item,items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });

    }
}
