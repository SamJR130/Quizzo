package com.hfad.quizzo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class AddQuestionFragment extends Fragment {

    View view;
    String genre;
    String question;
    String fact;
    String answer;


    public static final String ANS_KEY = "1";
    public static final String QUES_KEY = "Ques";
    public static final String GENRE_KEY = "Genre";
    public static final String FACT_KEY = "Fact";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_question, container, false);

        EditText tvAns1 = view.findViewById(R.id.choice1);
        EditText tvAns2 = view.findViewById(R.id.choice2);
        EditText tvAns3 = view.findViewById(R.id.choice3);
        EditText tvAns4 = view.findViewById(R.id.choice4);
        //EditText tvAns5 = view.findViewById(R.id.tv_ans5);

        ArrayList<String> options = new ArrayList<>();
        options.add(tvAns1.getText().toString());
        options.add(tvAns2.getText().toString());
        options.add(tvAns3.getText().toString());
        options.add(tvAns4.getText().toString());
        //options.add(tvAns5 + "");

        Spinner spinAns = view.findViewById(R.id.SpinnerChoices);
        TextView tvGenre = view.findViewById(R.id.Genre);
        TextView tvQues = view.findViewById(R.id.Text);
        TextView tvFunFact = view.findViewById(R.id.FollowUpFact);
        answer = spinAns.getSelectedItem().toString();
        Button btnAdd = view.findViewById(R.id.btnAdd);

        genre = tvGenre.getText().toString();
        question = tvQues.getText().toString();
        fact = tvFunFact.getText().toString();

        if (savedInstanceState != null)
        {
            genre = savedInstanceState.getString(GENRE_KEY);
            answer = savedInstanceState.getString(ANS_KEY);
            question = savedInstanceState.getString(QUES_KEY);
            fact = savedInstanceState.getString(FACT_KEY);
        }



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database.getDatabase().addQuestion(new Question(genre, question, options, answer, fact));
                Navigation.findNavController(view).navigate(R.id.action_addQuestionFragment_to_homeFragment);
            }
        });

        return view;
    }

    /**
     * This function allows the information to be stored on orientation
     * @param savedInstanceState What is being stored
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(GENRE_KEY, genre);
        savedInstanceState.putString(ANS_KEY, answer);
        savedInstanceState.putString(QUES_KEY, question);
        savedInstanceState.putString(FACT_KEY, fact);

    }
}