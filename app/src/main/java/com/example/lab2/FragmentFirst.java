package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.graphics.Typeface;
import android.widget.Toast;

public class FragmentFirst extends Fragment {

    private OnTextSubmitListener callback;

    public interface OnTextSubmitListener {
        void onTextSubmitted(String text, int fontStyle);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTextSubmitListener) {
            callback = (OnTextSubmitListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnTextSubmitListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        EditText editText = view.findViewById(R.id.text_edit);
        Button buttonOk = view.findViewById(R.id.button_ok);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup_fonts);

        buttonOk.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (text.isEmpty()) {
                Toast.makeText(getActivity(), "Nothing entered", Toast.LENGTH_SHORT).show();
                editText.setError("Field cannot be empty");
            } else {
                int fontStyle = Typeface.NORMAL;
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rb_bold) {
                    fontStyle = Typeface.BOLD;
                } else if (selectedId == R.id.rb_italic) {
                    fontStyle = Typeface.ITALIC;
                }
                callback.onTextSubmitted(text, fontStyle);
            }

        });

        return view;
    }
}

