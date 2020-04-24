package com.example.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MyPagerFragment extends Fragment {
    ViewPager pager;
    Pager_fragment1 pager_fragment1;
    Pager_fragment2 pager_fragment2;
    Pager_fragment3 pager_fragment3;
    Pager_fragment4 pager_fragment4;
    Pager_fragment5 pager_fragment5;
    Pager_fragment6 pager_fragment6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.mypagerfragment,container,false);

        pager = (ViewPager) rootview.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(6);

        MoviePagerAdapter adapter = new MoviePagerAdapter(getChildFragmentManager());


        pager_fragment1 = new Pager_fragment1();
        adapter.addItem(pager_fragment1);

        pager_fragment2 = new Pager_fragment2();
        adapter.addItem(pager_fragment2);

        pager_fragment3 = new Pager_fragment3();
        adapter.addItem(pager_fragment3);

        pager_fragment4 = new Pager_fragment4();
        adapter.addItem(pager_fragment4);

        pager_fragment5 = new Pager_fragment5();
        adapter.addItem(pager_fragment5);

        pager_fragment6 = new Pager_fragment6();
        adapter.addItem(pager_fragment6);

        pager.setAdapter(adapter);


        return rootview;
    }

    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public  void addItem(Fragment item) {
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

    }
}
