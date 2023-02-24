package com.example.capstonefinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Menu_Learning extends Fragment {
    private EditText learningStandardEditText, learningScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_learning, container, false);

        // Gets references to the EditText views
        learningStandardEditText = view.findViewById(R.id.learning_standard_edit_text);
        learningScoreEditText = view.findViewById(R.id.learning_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        learningStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("learning_standard", ""));
        learningScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("learning_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saves the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("learning_standard", learningStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("learning_score", learningScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Learning");
    }
}
