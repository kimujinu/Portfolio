package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class CommentWriteActivity extends AppCompatActivity {
    RatingBar ratingBar;
    EditText contentsInput;
    Button savebtn,cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);

        ratingBar = findViewById(R.id.ratingBar);
        contentsInput = findViewById(R.id.contentInput);
        savebtn = findViewById(R.id.savebtn);
        cancelbtn = findViewById(R.id.cancelbtn);

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_LONG).show();
                showSummaryActivity();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });
        Intent intent = getIntent();
        processIntent(intent);
    }
    public void showSummaryActivity() {

        Intent intent = new Intent(getApplicationContext(),Summary.class);
        startActivityForResult(intent,101);
    }

    private  void processIntent(Intent intent) {
        if(intent != null){
           float rating =  intent.getFloatExtra("rating",0.0f);
           ratingBar.setRating(rating);
        }
    }

    public void returnToMain() {
        String contents = contentsInput.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("contents", contents);

        setResult(RESULT_OK,intent);
        Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();
        showSummaryActivity();
    }
}
