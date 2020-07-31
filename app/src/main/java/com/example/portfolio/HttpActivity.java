package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    String urlstr;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        editText = findViewById(R.id.editText15);
        textView = findViewById(R.id.textView14);

        Button button = findViewById(R.id.button35);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlstr = editText.getText().toString();

                RequestThread thread = new RequestThread();
                thread.start();
            }
        });
    }

    class RequestThread extends Thread {
        public void run(){

            try {
                URL url = new URL(urlstr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if(conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    int resCode = conn.getResponseCode();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;

                    while (true) {
                        line = reader.readLine();
                        if(line == null) {
                            break;
                        }
                        println(line);
                    }

                    reader.close();
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();;
            }

        }
    }


    public void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data +"\n");
            }
        });

    }
}