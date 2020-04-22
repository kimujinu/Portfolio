package com.example.portfolio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    MyfragmentTest2 myFragmentTest2;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        myFragmentTest2 = (MyfragmentTest2) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list,container,false);

       Button btn = (Button)rootView.findViewById(R.id.button1);
       Button btn2 = (Button)rootView.findViewById(R.id.button2);
       Button btn3 = (Button)rootView.findViewById(R.id.button3);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                myFragmentTest2.onImageChange(0);
           }
       });

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               myFragmentTest2.onImageChange(1);
           }
       });

       btn3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               myFragmentTest2.onImageChange(2);
           }
       });
        return rootView;
    }
}
