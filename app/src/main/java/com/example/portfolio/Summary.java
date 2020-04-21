package com.example.portfolio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Summary extends AppCompatActivity {
    Button likebutton;
    Button hatebutton,writebtn,seebtn;
    TextView likeCountView;
    TextView hateCountView;
    CommentAdapter adapter;
    ListView listView;
    boolean likestate = false;
    boolean hatestate = false;
    int likeCount = 0;
    int hateCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        likebutton = findViewById(R.id.likeCount);
        likeCountView = findViewById(R.id.likeCountView);
        hatebutton = findViewById(R.id.hateCount);
        hateCountView = findViewById(R.id.hateCountView);
        writebtn = findViewById(R.id.writebtn);
        seebtn = findViewById(R.id.Seebtn);

        listView = findViewById(R.id.listview3);
        adapter = new CommentAdapter();

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();
            }
        });
        seebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentlistActivity();
            }
        });

        hatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hatestate==true){
                    decrhateCount();
                }else if(hatestate==false){
                    incrhateCount();
                }
                if(hatestate==true && likestate==true){
                    decrLikeCount();
                }

            }
        });

        likebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likestate==true){
                    decrLikeCount();
                }else if(likestate==false){
                    incrLikeCount();
                }
                if(hatestate==true && likestate==true){
                   decrhateCount();
                }

            }
        });


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Profile item = (Profile) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getId(), Toast.LENGTH_LONG).show();
            }
        });
        adapter.addItem(new Profile("강동원","10분전","강동원 너무 잘생겼네","추천 0  | ","신고하기",5 , R.drawable.user1));
        adapter.addItem(new Profile("skssk35**","21분전","마동석 멋있다.","추천 1  | ","신고하기",3 , R.drawable.user1));

    }
    public void incrLikeCount() {
        likeCount+=1;
        likeCountView.setText(String.valueOf(likeCount));

        likebutton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
        likestate = true;
    }

    public void decrLikeCount() {
        likeCount-=1;
        likeCountView.setText(String.valueOf(likeCount));

        likebutton.setBackgroundResource(R.drawable.thumbs_up_selector);
        likestate = false;

    }
    public void incrhateCount() {
        hateCount+=1;
        hateCountView.setText(String.valueOf(hateCount));

        hatebutton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
        hatestate = true;
    }

    public void decrhateCount() {
        hateCount-=1;
        hateCountView.setText(String.valueOf(hateCount));

        hatebutton.setBackgroundResource(R.drawable.thumbs_down_selector);
        hatestate = false;
    }
    public void showCommentWriteActivity() {

        Intent intent = new Intent(getApplicationContext(),CommentWriteActivity.class);
        startActivityForResult(intent,101);
    }

    public void showCommentlistActivity() {

        Intent intent = new Intent(getApplicationContext(),commentList.class);
        startActivityForResult(intent,101);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 101) {
            if(intent != null) {

            }
        }
    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<Profile> items = new ArrayList<Profile>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Profile item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = new CommentItemView(getApplicationContext());

            if(convertView == null) {
                view = new CommentItemView(getApplicationContext());
            }else{
                view = (CommentItemView) convertView;
            }

            Profile item = items.get(position);
            view.setIdText(item.getId());
            view.setTimeText(item.getTime());
            view.setCommentText(item.getComment());
            view.setLikeText(item.getLike());
            view.setReportText(item.getReport());
            view.setRatingbar(item.getRating());
            view.setImage(item.getImage());
            return view;
        }
    }

    class Profile {
        String id;
        String time;
        String comment;
        String like;
        String report;
        float Rating;
        int resid;

        public Profile(String id, String time, String comment, String like, String report, float rating, int resid) {
            this.id = id;
            this.time = time;
            this.comment = comment;
            this.like = like;
            this.report = report;
            this.Rating = rating;
            this.resid = resid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getReport() {
            return report;
        }

        public void setReport(String report) {
            this.report = report;
        }

        public float getRating() {
            return Rating;
        }

        public void setRating(float rating) {
            Rating = rating;
        }

        public int getImage() {
            return resid;
        }

        public void setImage(int resid) {
            this.resid = resid;
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "id='" + id + '\'' +
                    ", time='" + time + '\'' +
                    ", comment='" + comment + '\'' +
                    ", like='" + like + '\'' +
                    ", report='" + report + '\'' +
                    ", Rating=" + Rating +
                    ", resid=" + resid +
                    '}';
        }
    }
}