package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EventTest extends AppCompatActivity {
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);

        textView = (TextView) findViewById(R.id.textView);
        View view = findViewById(R.id.view);
        View view2 = findViewById(R.id.view2);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    print("손가락 눌렸음 : "+ curX + ", "+ curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    print("손가락 움직임 : "+ curX + ", "+ curY);
                }else if(action == MotionEvent.ACTION_UP){
                    print("손가락 떼졌음 : "+ curX + ", "+ curY);
                }

                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                print("onDown() 호출. ");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                print("onShowPress() 호출. ");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                print("onSingleTapUp() 호출. ");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                print("onScroll() 호출. " +distanceX+", "+distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                print("onLongPress() 호출. ");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                print("onFling() 호출. "+velocityX+", "+velocityY);
                return true;
            }
        });
            view2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    detector.onTouchEvent(event);
                    return true;
                }
            });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this,"시스템 BACK 버튼 눌림.", Toast.LENGTH_LONG).show();

            return true;
        }
        return false;
    }

    public void print(String data){
        textView.append(data+ "\n");
    }
}
