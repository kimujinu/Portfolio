package com.example.portfolio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentTest extends AppCompatActivity {
    Button btn,btn2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);

        btn = findViewById(R.id.menubtn);
        btn2 = findViewById(R.id.button25);
        editText = findViewById(R.id.editText4);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuTest.class);
                startActivityForResult(intent, 101);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiver = editText.getText().toString();

                Intent intent2 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+receiver));
                startActivity(intent2);

                Intent intent3 = new Intent();
                ComponentName name = new ComponentName("com.example.portfolio","com.example.portfolio.InentTest");
                intent3.setComponent(name);
                startActivity(intent3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
         String name =  data.getStringExtra("name");
         Toast.makeText(getApplicationContext(), "메누화면으로부터 응답 : "+ name,Toast.LENGTH_LONG).show();
        }

    }
}
