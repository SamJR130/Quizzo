package com.hfad.quizzo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuizCompleteFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_complete, container, false);

        TextView tvGrade = view.findViewById(R.id.tv_grade);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        String grade  = QuizCompleteFragmentArgs.fromBundle(requireArguments()).getGrade();
        double percent = Double.parseDouble(grade);
        String num = String.format("%.2f", percent);

        tvGrade.setText("Score: " + num + "%");
        if (percent > 70)
        {
            tvMessage.setText("Keep up the good work!");
        }
        else
        {
            tvMessage.setText("Study harder next time. :(");
        }

        return view;
    }
}