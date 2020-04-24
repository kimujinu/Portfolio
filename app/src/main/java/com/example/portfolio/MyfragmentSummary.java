package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyfragmentSummary extends AppCompatActivity implements FragmentSummaryCallback{
    FragmentSummary1 fragmentSummary1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfragment_summary);

        btn = findViewById(R.id.button30);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentSummary1 != null) {
                    fragmentSummary1.onCommandFromActivity("show","액티비티로 부터 전달됨");
                }
            }
        });

        fragmentSummary1 = new FragmentSummary1();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragmentSummary1).commit();

    }

    public void onCommand(String command, String data) {
        btn.setText(data);
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {

    }

}
