package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListviewTest extends AppCompatActivity {
    ListView listView;
    SingerAdapter adapter;

    EditText editText;
    EditText editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);

        listView = findViewById(R.id.listview2);
        editText = findViewById(R.id.editText2);
        editText2 = findViewById(R.id.editText3);
        button = findViewById(R.id.btn5);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("버스커버스커","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커버스","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커버","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스","010-1234-4564",R.drawable.ic_facebook));


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(), Toast.LENGTH_LONG).show();
            }
        });
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = editText.getText().toString();
               String mobile = editText2.getText().toString();

               adapter.addItem(new SingerItem(name, mobile ,R.drawable.ic_facebook));
               adapter.notifyDataSetChanged(); //갱신
           }
       });

    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
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

            SingeritemView view = new SingeritemView(getApplicationContext());

            if(convertView == null) {
                view = new SingeritemView(getApplicationContext());
            }else{
                view = (SingeritemView) convertView;
            }

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResid());
            return view;
        }
    }
}

    class SingerItem {
        String name;
        String mobile;
        int resid;

        public SingerItem(String name, String mobile,int resid) {
            this.name = name;
            this.mobile = mobile;
            this.resid = resid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getResid() {
            return resid;
        }

        public void setResid(int resid) {
            this.resid = resid;
        }

        @Override
        public String toString() {
            return "SingerItem{" +
                    "name='" + name + '\'' +
                    ", mobile='" + mobile + '\'' +
                    '}';
        }
    }