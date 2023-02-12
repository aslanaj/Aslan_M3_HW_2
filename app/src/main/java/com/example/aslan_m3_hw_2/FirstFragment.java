package com.example.aslan_m3_hw_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private Button btnPlus, btnMines, btnGo;
    private TextView textView;
    static final String KEY_FOR_SECOND_FRAGMENT = "1";
    private static int counter = 1;
    private String stringValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private void initListener() {
        counterPlus();
        counterMines();
        btnGo();
    }

    private void btnGo() {
        btnGo.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_SECOND_FRAGMENT, textView.getText().toString());
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, secondFragment)
                    .addToBackStack(null).commit();
        });
    }

    private void counterMines() {
        btnMines.setOnClickListener(view -> {
            counter--;
            stringValue = Integer.toString(counter);
            textView.setText(stringValue);
        });

    }

    private void counterPlus() {
        btnPlus.setOnClickListener(view -> {
            counter++;
            stringValue = Integer.toString(counter);
            textView.setText(stringValue);
        });
    }

    private void initView() {
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        btnMines = requireActivity().findViewById(R.id.btn_mines);
        textView = requireActivity().findViewById(R.id.tv_first_fragment);
        btnGo = requireActivity().findViewById(R.id.bnt_go);
    }

}