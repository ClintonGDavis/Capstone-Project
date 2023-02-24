package com.example.capstonefinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Play extends Fragment {
    private EditText playStandardEditText, playScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_play, container, false);

        // Gets references to the EditText views
        playStandardEditText = view.findViewById(R.id.play_standard_edit_text);
        playScoreEditText = view.findViewById(R.id.play_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        playStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("play_standard", ""));
        playScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("play_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saves the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("play_standard", playStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("play_score", playScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Play");
    }
}
