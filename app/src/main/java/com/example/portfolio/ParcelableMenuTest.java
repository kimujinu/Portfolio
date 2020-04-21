package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ParcelableMenuTest extends AppCompatActivity {
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable_menu_test);

        backbtn = findViewById(R.id.rewindbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passInent = getIntent();
        processIntent(passInent);
    }

    private  void processIntent(Intent intent){
        if(intent != null) {
            ArrayList<String> names = (ArrayList<String>)intent.getSerializableExtra("names");
            if(names != null) {
                Toast.makeText(getApplicationContext(), "전달받은 이름 리스트의 갯수 :" +names.size(),Toast.LENGTH_LONG).show();
            }

            SimpleData data = intent.getParcelableExtra("data");
            if(data !=null){
                Toast.makeText(getApplicationContext(),"전달받은 SimpleData : "+data.message,Toast.LENGTH_LONG).show();
            }
        }
    }
}
