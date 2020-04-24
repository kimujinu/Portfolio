package com.example.portfolio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Pager_fragment1 extends Fragment {
    Button Detailbtn;
    SummaryStart summaryStart;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        summaryStart = (SummaryStart) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        summaryStart = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.pager_fragment1,container,false);

       Detailbtn = rootview.findViewById(R.id.Detailbtn);

       Detailbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                summaryStart.onFragmentChange(1);
                //Intent intent = new Intent(getActivity(), Summary.class);
               // startActivity(intent);
           }
       });

       return rootview;
    }
}
