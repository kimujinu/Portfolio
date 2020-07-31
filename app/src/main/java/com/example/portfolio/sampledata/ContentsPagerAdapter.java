package com.example.portfolio.sampledata;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.portfolio.Fragment1;
import com.example.portfolio.Fragment2;
import com.example.portfolio.Fragment3;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 homeFragment = new Fragment1();
                return homeFragment;
            case 1:
                Fragment2 gameFragment = new Fragment2();
                return gameFragment;
            case 2:
                Fragment3 movieFragment = new Fragment3();
                return movieFragment;
            case 3:
                Fragment1 bookFragment = new Fragment1();
                return bookFragment;
            case 4:
                Fragment2 newsFragment = new Fragment2();
                return newsFragment;
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return mPageCount;
    }

}