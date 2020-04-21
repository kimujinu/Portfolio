package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSReceiverTest extends AppCompatActivity {
    EditText editText,editText2,editText3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsreceiver_test);

        editText = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText7);
        editText3 = findViewById(R.id.editText8);

        btn = findViewById(R.id.button24);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent passedInent = getIntent();
        processCommand(passedInent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }

    private void processCommand(Intent intent){
        if(intent != null) {
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            editText.setText(sender);
            editText2.setText(contents);
            editText3.setText(receivedDate);
        }
    }

}
