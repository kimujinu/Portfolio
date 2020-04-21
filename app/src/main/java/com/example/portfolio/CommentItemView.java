package com.example.portfolio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {
    TextView idText;
    TextView timeText;
    TextView CommentText;
    TextView likeText;
    TextView reportText;
    RatingBar Ratingbar;
    ImageView profileimage;


    public CommentItemView(Context context) {
        super(context);

        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private  void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.commet_item_view, this,true);

        idText = findViewById(R.id.idText);
        timeText = findViewById(R.id.TimeText);
        CommentText = findViewById(R.id.CommentText);
        likeText = findViewById(R.id.likeText);
        reportText = findViewById(R.id.reportText);
        Ratingbar =  findViewById(R.id.Ratingbar);
        profileimage = findViewById(R.id.profileimage);
    }
    public void setIdText(String id) {
        idText.setText(id);
    }
    public void setTimeText(String time) {
        timeText.setText(time);
    }
    public void setCommentText(String comment) {
        CommentText.setText(comment);
    }
    public void setLikeText(String like) {
        likeText.setText(like);
    }
    public void setReportText(String report) {
        reportText.setText(report);
    }
    public void setRatingbar(float Rating) {
        Ratingbar.setRating(Rating);
    }
    public void setImage(int resid){
        profileimage.setImageResource(resid);
    }

}
