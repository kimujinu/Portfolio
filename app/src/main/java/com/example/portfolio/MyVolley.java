package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MyVolley extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_volley);

        textView = findViewById(R.id.textView15);
        Button button = findViewById(R.id.button36);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        if (AppHelper_Volley.requestQueue == null) {
            AppHelper_Volley.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    public void sendRequest() {
        //String url = "https://www.google.co.kr";
        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -  "+ response);

                        procesResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 ->" + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        request.setShouldCache(false);
        AppHelper_Volley.requestQueue.add(request);
        println("요청 보냄.");

    }

    public void procesResponse(String response){
        Gson gson = new Gson();
        MovieList_gson movieList_gson= gson.fromJson(response, MovieList_gson.class);

        if (movieList_gson != null) {
            int countMovie = movieList_gson.boxOfficeResult.dailyBoxOfficeList.size();
            println("박스오피스 타입 : " + movieList_gson.boxOfficeResult.boxofficeType);
            println("응답받은 영화 갯수 : "+countMovie);
        }
    }

    public void println(String data) {
        textView.append(data + "\n");
    }
}