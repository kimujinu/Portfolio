package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         imageView = (ImageView) findViewById(R.id.imageView);
         imageView2 = (ImageView) findViewById(R.id.imageView2);
         RadioButton radioButton = findViewById(R.id.radioButton);
         boolean checked = radioButton.isChecked();
    }
    public void onButton3Clicked(View v){
        index += 1;
        if(index > 1) {
            index = 0;
        }
        if(index == 0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }else if(index == 1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }

    }
    public void onButton4Clicked(View v){
        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }
}
