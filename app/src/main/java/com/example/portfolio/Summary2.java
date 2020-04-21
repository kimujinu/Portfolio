package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

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

public class Summary2 extends AppCompatActivity {
    Button likebutton;
    TextView likeCountView;
    CommentAdapter adapter;
    ListView listView;
    boolean likestate = false;
    boolean hatestate = false;
    int likeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary2);

        likebutton = findViewById(R.id.likeCount);
        likeCountView = findViewById(R.id.likeCountView);
        listView = findViewById(R.id.listview3);
        adapter = new CommentAdapter();

        likebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likestate){
                    decrLikeCount();
                }else{
                    incrLikeCount();
                }

                likestate = !likestate;
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
        adapter.addItem(new Profile("강동원","10분전","강동원 너무 잘생겼네","추천 0  | ","신고하기",5 , R.drawable.user1));

    }
    public void incrLikeCount() {
        likeCount+=1;
        likeCountView.setText(String.valueOf(likeCount));

        likebutton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount-=1;
        likeCountView.setText(String.valueOf(likeCount));

        likebutton.setBackgroundResource(R.drawable.thumbs_up_selector);
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
