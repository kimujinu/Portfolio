package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MySocket extends AppCompatActivity {
    TextView textView;

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_socket);

        textView = findViewById(R.id.textView13);
        Button btn = findViewById(R.id.button34);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }

    class ClientThread extends Thread {
        public void run() {
            String host = "localhost";
            int port = 5001;
            try {
               Socket socket = new Socket(host, port);

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject("안녕!");
                outputStream.flush();
                Log.d("ClientThread","서버로 보냄");

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                final Object input = inputStream.readObject();
                Log.d("ClientThread","받은 데이터 : "+ input);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("받은 데이터 : "+input);
                    }
                });



            }catch (Exception e) {

            }
        }
    }
}
