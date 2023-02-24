package com.example.capstonefinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Safety extends Fragment {
    private EditText safetyStandardEditText, safetyScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_safety, container, false);

        // Gets references to the EditText views
        safetyStandardEditText = view.findViewById(R.id.safety_standard_edit_text);
        safetyScoreEditText = view.findViewById(R.id.safety_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        safetyStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("safety_standard", ""));
        safetyScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("safety_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saves the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("safety_standard", safetyStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("safety_score", safetyScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Safety");
    }
}
