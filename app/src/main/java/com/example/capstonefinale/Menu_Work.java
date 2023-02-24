package com.example.capstonefinale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Work extends Fragment {
    private EditText workStandardEditText, workScoreEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_work, container, false);

        // Gets references to the EditText views
        workStandardEditText = view.findViewById(R.id.work_standard_edit_text);
        workScoreEditText = view.findViewById(R.id.work_score_edit_text);

        // Loads the saved values from SharedPreferences and sets them to the EditText views
        workStandardEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("work_standard", ""));
        workScoreEditText.setText(((MainActivity) getActivity()).getStringFromSharedPreferences("work_score", ""));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Saves the current input values in the EditText views to SharedPreferences
        ((MainActivity) getActivity()).saveStringToSharedPreferences("work_standard", workStandardEditText.getText().toString());
        ((MainActivity) getActivity()).saveStringToSharedPreferences("work_score", workScoreEditText.getText().toString());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Work");
    }
}
