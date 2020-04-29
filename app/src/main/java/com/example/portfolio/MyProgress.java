package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyProgress extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress);

        progressBar = findViewById(R.id.progressBar);

        Button button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressTask task = new ProgressTask();
                task.execute("Start");
            }
        });

    }
    class ProgressTask extends AsyncTask<String, Integer, Integer> {

        int value = 0;

        @Override
        protected Integer doInBackground(String... strings) { //쓰레드안에서 무엇을 동작하겠다. 처리용 코드 작성 함수
            while(true){
                if(value >= 100)
                    break;

                value += 4;

                publishProgress(value);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) { //중간 중간 UI 업데이트 작성 코드
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) { //완료 코드 작성 함수
            super.onPostExecute(integer);

            Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_LONG).show();
        }

    }
}
