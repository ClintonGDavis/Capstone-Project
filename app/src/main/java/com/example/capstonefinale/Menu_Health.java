package com.example.capstonefinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Health extends Fragment {
    private EditText healthStandardEditText, healthScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_health, container, false);

        // Gets references to the EditText views
        healthStandardEditText = view.findViewById(R.id.health_standard_edit_text);
        healthScoreEditText = view.findViewById(R.id.health_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        healthStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("health_standard", ""));
        healthScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("health_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saves the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("health_standard", healthStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("health_score", healthScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Health");
    }
}
