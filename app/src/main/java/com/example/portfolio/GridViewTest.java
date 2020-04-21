package com.example.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewTest extends AppCompatActivity {
    GridView gridView;
    SingerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_test);

        gridView = findViewById(R.id.gridView);
        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("버스커버스커","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커버스","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커버","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스커","010-1234-4564",R.drawable.ic_facebook));
        adapter.addItem(new SingerItem("버스","010-1234-4564",R.drawable.ic_facebook));


        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(), Toast.LENGTH_LONG).show();
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
