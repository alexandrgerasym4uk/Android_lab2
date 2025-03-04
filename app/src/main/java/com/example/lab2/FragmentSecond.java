package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {

    private static final String ARG_TEXT = "text";
    private static final String ARG_FONT = "font";

    public static FragmentSecond newInstance(String text, int fontStyle) {
        FragmentSecond fragment = new FragmentSecond();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_FONT, fontStyle);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView textView = view.findViewById(R.id.text_view);
        Button buttonCancel = view.findViewById(R.id.button_cancel);

        if (getArguments() != null) {
            String text = getArguments().getString(ARG_TEXT);
            int fontStyle = getArguments().getInt(ARG_FONT);
            textView.setText(text);
            textView.setTypeface(null, fontStyle);
        }

        buttonCancel.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        return view;
    }
}

