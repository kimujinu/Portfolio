package com.example.portfolio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSummary1 extends Fragment {
    FragmentSummaryCallback callback;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof  FragmentSummaryCallback) {
            callback = (FragmentSummaryCallback) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(callback != null) {
            callback = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragmentsummary1,container,false);

        textView = rootview.findViewById(R.id.textView12);

        Button btn = rootview.findViewById(R.id.button29);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null) {
                    callback.onCommand("show","프래그먼트1에서 전달함");
                }
            }
        });

        return rootview;
    }

    public  void onCommandFromActivity(String command,String data) {
        textView.setText(data);
    }
}
