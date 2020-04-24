package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyFragmentTest extends AppCompatActivity {
    MainFragment fragment1;
    MenuFragment fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment_test); //프래그먼트는 xml레이아웃 파일1개 자바소스파일 1개로 이루어짐
                                                            //MyfragmentTest, mainFragment(fragment_main), menuFragment(fragment_menu)
        Button btn = findViewById(R.id.fragbtn);
        Button btn2 = findViewById(R.id.menufragbtn);

        fragment1  = new MainFragment();
        fragment2 = new MenuFragment();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }

    public void onFragmentChange(int index) {
        if(index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
        }else if(index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }
    }
}
