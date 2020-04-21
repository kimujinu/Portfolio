package com.example.portfolio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Summary3 extends AppCompatActivity {
    RatingBar ratingBar;
    Button btn;
    TextView outputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary3);

        ratingBar = findViewById(R.id.ratingBar);
        btn = findViewById(R.id.button26);
        outputView = findViewById(R.id.outputView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();
            }
        });


    }
    public void showCommentWriteActivity() {
        float rating = ratingBar.getRating();

        Intent intent = new Intent(getApplicationContext(),CommentWriteActivity.class);
        intent.putExtra("rating",rating);
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101) {
            if(intent != null) {
                String contents = intent.getStringExtra("contents");
                outputView.setText(contents);
            }
        }
    }
}
