package com.example.capstonefinale;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu_Summary extends Fragment {

    private TextView loveStandardTextView, loveScoreTextView, workStandardTextView, workScoreTextView,
            learningStandardTextView, learningScoreTextView, playStandardTextView, playScoreTextView,
            healthStandardTextView, healthScoreTextView, safetyStandardTextView, safetyScoreTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_summary, container, false);

        // Gets references to the TextViews
        loveStandardTextView = view.findViewById(R.id.love_standard_edit_text);
        loveScoreTextView = view.findViewById(R.id.love_score_edit_text);
        workStandardTextView = view.findViewById(R.id.work_standard_edit_text);
        workScoreTextView = view.findViewById(R.id.work_score_edit_text);
        learningStandardTextView = view.findViewById(R.id.learning_standard_edit_text);
        learningScoreTextView = view.findViewById(R.id.learning_score_edit_text);
        playStandardTextView = view.findViewById(R.id.play_standard_edit_text);
        playScoreTextView = view.findViewById(R.id.play_score_edit_text);
        healthStandardTextView = view.findViewById(R.id.health_standard_edit_text);
        healthScoreTextView = view.findViewById(R.id.health_score_edit_text);
        safetyStandardTextView = view.findViewById(R.id.safety_standard_edit_text);
        safetyScoreTextView = view.findViewById(R.id.safety_score_edit_text);

        // Sets the text of each TextView to the corresponding values from SharedPreferences
        loveStandardTextView.setText("Love Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("love_standard", ""));
        loveScoreTextView.setText("Love Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("love_score", ""));
        workStandardTextView.setText("Work Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("work_standard", ""));
        workScoreTextView.setText("Work Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("work_score", ""));
        learningStandardTextView.setText("Learning Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("learning_standard", ""));
        learningScoreTextView.setText("Learning Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("learning_score", ""));
        playStandardTextView.setText("Play Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("play_standard", ""));
        playScoreTextView.setText("Play Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("play_score", ""));
        healthStandardTextView.setText("Health Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("health_standard", ""));
        healthScoreTextView.setText("Health Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("health_score", ""));
        safetyStandardTextView.setText("Safety Standard: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("safety_standard", ""));
        safetyScoreTextView.setText("Safety Score: " + ((MainActivity) requireActivity()).getStringFromSharedPreferences("safety_score", ""));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().setTitle("Summary");
    }
}
