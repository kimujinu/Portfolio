package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_server);

        Button btn = findViewById(R.id.button33);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ServerThread thread = new ServerThread();
//                thread.start();

                Intent intent = new Intent(getApplicationContext(),chatService.class);
                startService(intent);
            }
        });
    }

  /* class ServerThread extends Thread {
        public  void  run() {
            int port = 5001;

            try {
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread","서버가 실행됨.");

                while (true) {
                    Socket socket = server.accept();

                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    Object input = inputStream.readObject();
                    Log.d("ServerThread","input : "+ input);

                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(input + "from Server");
                    outputStream.flush();
                    Log.d("ServerThread","output 보냄.");

                    socket.close();
                }
            }catch (Exception e ) {
                e.printStackTrace();
            }
        }
   }
   */



}
