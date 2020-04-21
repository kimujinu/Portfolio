package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ParcelableTest extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_test);

        btn = findViewById(R.id.Parcebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ParcelableMenuTest.class);

                ArrayList<String> names = new ArrayList<String>();
                names.add("김나연");
                names.add("김찌뽀");

                intent.putExtra("names",names);

                SimpleData data = new SimpleData(100,"Hello");
                intent.putExtra("data",data);

                startActivityForResult(intent,101);
            }
        });
    }
}
