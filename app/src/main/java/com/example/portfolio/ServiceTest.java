package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceTest extends AppCompatActivity {
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        editText = findViewById(R.id.editText5);
        btn = findViewById(R.id.Servicebtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name",name);
                startService(intent);
            }
        });

        Intent passedIntent = getIntent();
        processCommand(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }

    private  void  processCommand(Intent intent) {
        if(intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this,"서비스로부터 전달받은 데이터 : "+ command +", "+name,Toast.LENGTH_LONG).show();

        }
    }
}
