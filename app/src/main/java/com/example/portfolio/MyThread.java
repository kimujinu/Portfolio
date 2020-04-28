package com.example.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyThread extends AppCompatActivity {
    TextView textView;
    Button button,button1;
  //  int value =0;
    ValueHandler handler = new ValueHandler();

    Handler handler2 = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_thread);

        textView = findViewById(R.id.textView11);
        button = findViewById(R.id.button31);
        button1 = findViewById(R.id.button32);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
              //  BackgroundThread thread = new BackgroundThread();
              //  thread.start();
                new Thread(new Runnable() {
                    int value = 0;
                    boolean running = false;
                    @Override
                    public void run() {
                        running = true;
                        while (running) {
                            value += 1;
                             handler2.post(new Runnable() {
                                 @Override
                                 public void run() {
                                     textView.setText("현재 값 : "+ value);
                                 }
                             });
                            try {
                                Thread.sleep(1000);
                            }catch (Exception e) {

                            }
                        }

                    }
                }).start();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   // textView.setText("현재 값 : "+ value);
            }
        });

    }

        class BackgroundThread extends Thread {
        int value = 0;
            boolean running = false;
            public void run() {
                running = true;
                while (running)     {
                    value += 1;
                    Message message = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("value",value);
                    message.setData(bundle);
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {

                    }
                }
            }
        }

        class ValueHandler extends Handler {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                Bundle bundle = msg.getData();
                int value = bundle.getInt("value");
                textView.setText("현재 값 : "+value);
            }
        }

}
