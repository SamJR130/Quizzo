package com.hfad.quizzo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticeFragment extends Fragment{

    TextView tvQuesAmt;
    TextView tvResponse;
    //RadioGroup radioButtons;
    RadioButton rbOne, rbTwo, rbThree, rbFour, rbFive;
    ArrayList <RadioButton> radioButtons = new ArrayList<RadioButton>();
    Button btnNext;
    boolean isCorrect = true;
    double grade = 0;
    int totalQues = 0;
    int currQuesCTR = 0;
    String genre;
    String selectAns;
    String rightAnswer;


    //KEYS for use with the bundle
    public static final String IS_CORRECT_KEY = "true";
    public static final String GRADE_KEY = "1";
    public static final String TOTAL_QUES_KEY = "Total Ques";
    public static final String CURR_QUES_CTR_KEY = "Current Ques";
    public static final String GENRE_KEY = "Current Genre";
    public static final String SELECT_ANS_KEY = "Selected Ans";
    public static final String RIGHT_ANS_KEY = "Correct Ans";


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_practice, container, false);
        genre = PracticeFragmentArgs.fromBundle(requireArguments()).getGenre();

        ArrayList<Question> quizQuestions = Database.retrieveQuestionsWithGenre(genre);
        totalQues = quizQuestions.size();

        tvQuesAmt = view.findViewById(R.id.tv_ques_count);
        tvResponse = view.findViewById(R.id.tv_question);
        btnNext = view.findViewById(R.id.btn_next);
        rbOne = view.findViewById(R.id.rb_one);
        rbTwo = view.findViewById(R.id.rb_two);
        rbThree = view.findViewById(R.id.rb_three);
        rbFour = view.findViewById(R.id.rb_four);
        rbFive = view.findViewById(R.id.rb_five);
        tvResponse.setText(genre);
        radioButtons.add(rbOne);
        radioButtons.add(rbTwo);
        radioButtons.add(rbThree);
        radioButtons.add(rbFour);
        radioButtons.add(rbFive);

        //Check the saved instance state
        if (savedInstanceState != null)
        {
            isCorrect = savedInstanceState.getBoolean(IS_CORRECT_KEY);

            grade = savedInstanceState.getDouble(GRADE_KEY);

            totalQues = savedInstanceState.getInt(TOTAL_QUES_KEY);
            currQuesCTR = savedInstanceState.getInt(CURR_QUES_CTR_KEY);
            tvQuesAmt.setText("Question " + (currQuesCTR + 1) + " of " + totalQues);
            genre = savedInstanceState.getString(GENRE_KEY);
            selectAns = savedInstanceState.getString(SELECT_ANS_KEY);
            rightAnswer = savedInstanceState.getString(RIGHT_ANS_KEY);

        }

        tvQuesAmt.setText("Question " + (currQuesCTR + 1) + " of " + totalQues);

        loadQues(quizQuestions.get(currQuesCTR));

        //currQuesCTR++;

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                selectAns = getSelectedAns();

                rightAnswer = quizQuestions.get(currQuesCTR).getAnswer();

                if (selectAns.equals(rightAnswer))
                {
                    isCorrect = true;
                    grade++;
                }
                else
                {
                    isCorrect = false;
                }
                if (isCorrect)
                {
                    Toast.makeText(getContext(), "Correct!\nFun Fact: " + quizQuestions.get(currQuesCTR).getFact(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(), "Incorrect.\nFun Fact: " + quizQuestions.get(currQuesCTR).getFact(), Toast.LENGTH_SHORT).show();
                }
                currQuesCTR++;
                if (currQuesCTR == totalQues)
                {


                    grade = (100 * (grade / totalQues));
                    PracticeFragmentDirections.ActionPracticeFragmentToQuizCompleteFragment action =
                            PracticeFragmentDirections.actionPracticeFragmentToQuizCompleteFragment(String.valueOf(grade));
                    Navigation.findNavController(view).navigate(action);
                    //loadQues(quizQuestions.get(currQuesCTR));
                }
                else
                {
                    loadQues(quizQuestions.get(currQuesCTR));

                }


                tvQuesAmt.setText("Question " + (currQuesCTR +1) + " of " + totalQues);
            }
        });
        return view;
    }

    private void loadQues(Question q)
    {
        tvResponse.setText(q.getQuestion());

        for (int i = 0; i < q.getOptions().size(); i++)
        {
            radioButtons.get(i).setVisibility(View.VISIBLE);
            radioButtons.get(i).setText(q.getOptions().get(i));
        }

        for (int i = 0; i < radioButtons.size(); i++)
        {
            if ((radioButtons.get(i).getVisibility() != View.VISIBLE))
            {
                radioButtons.get(i).setVisibility(View.GONE);
            }
        }
    }

    private String getSelectedAns() {

        if (radioButtons.get(0).isChecked())
        {
            return radioButtons.get(0).getText().toString();
        }
        else if (radioButtons.get(1).isChecked())
        {
            return radioButtons.get(1).getText().toString();
        }
        else if (radioButtons.get(2).isChecked())
        {
            return radioButtons.get(2).getText().toString();
        }
        else if(radioButtons.get(3).isChecked())
        {
            return radioButtons.get(3).getText().toString();
        }
        else
        {
            return radioButtons.get(4).getText().toString();
        }
    }

    /**
     * This function allows the information to be stored on orientation
     * @param savedInstanceState What is being stored
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putBoolean(IS_CORRECT_KEY, isCorrect);
        savedInstanceState.putDouble(GRADE_KEY, grade);
        savedInstanceState.putInt(TOTAL_QUES_KEY, totalQues);
        savedInstanceState.putInt(CURR_QUES_CTR_KEY, currQuesCTR);
        savedInstanceState.putString(GENRE_KEY, genre);
        savedInstanceState.putString(SELECT_ANS_KEY, selectAns);
        savedInstanceState.putString(RIGHT_ANS_KEY, rightAnswer);

    }
}