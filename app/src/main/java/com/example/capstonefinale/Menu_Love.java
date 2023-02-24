package com.example.capstonefinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Love extends Fragment {

    private EditText loveStandardEditText, loveScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_love, container, false);

        // Gets references to the EditText views
        loveStandardEditText = view.findViewById(R.id.love_standard_edit_text);
        loveScoreEditText = view.findViewById(R.id.love_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        loveStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("love_standard", ""));
        loveScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("love_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Save the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("love_standard", loveStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("love_score", loveScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Love");
    }
}
