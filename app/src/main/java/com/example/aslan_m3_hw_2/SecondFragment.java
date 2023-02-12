package com.example.aslan_m3_hw_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        getData();
    }

    private void getData() {
        if(getArguments() != null){
            String tvResult = getArguments().getString(FirstFragment.KEY_FOR_SECOND_FRAGMENT);
            textView.setText(tvResult);
        }
    }

    private void initView() {
        textView = requireActivity().findViewById(R.id.tv_second_fragment);
    }
}