package com.example.portfolio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingeritemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    ImageView imageView;
    public SingeritemView(Context context) {
        super(context);

        init(context);
    }

    public SingeritemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this,true);
        textView = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView2);
    }

    public void  setName(String name) {
        textView.setText(name);
    }
    public void setMobile(String mobile){
        textView2.setText(mobile);
    }
    public void setImage(int resid){
        imageView.setImageResource(resid);
    }
}
