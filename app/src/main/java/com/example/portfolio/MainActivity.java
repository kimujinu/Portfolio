package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(),"버튼 눌림",Toast.LENGTH_LONG).show();
    }
    public void onButton2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
    public  void onButton3Clicked(View v){
        Intent intent2 = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent2);
    }
}
