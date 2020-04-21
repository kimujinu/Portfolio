package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ToastTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_test);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast toast =  Toast.makeText(getApplicationContext(), "위치가 바뀐 토스트",Toast.LENGTH_LONG);
              toast.setGravity(Gravity.TOP | Gravity.LEFT,200,200);
              toast.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView text = layout.findViewById(R.id.text);
                text.setText("모양을 바꾼 Toast");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0 , -100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show(); //스낵바를 쓰려면 외부 라이브러리 필요
            }
        });
    }
}
