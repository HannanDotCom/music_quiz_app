package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Questions_Activity extends AppCompatActivity implements View.OnClickListener {
    private int initCurrPosition = 1;
    private ArrayList<Question> initQuestionsList = null;
    private int selectedOptionPosition = 0;
    private int correctAnswers = 0;
    private String thisUsername = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Constants constants = new Constants();

        thisUsername = getIntent().getStringExtra(constants.USER_NAME);
        initQuestionsList = constants.getQuestions();

        setQuestion();
        TextView optionOne = findViewById(R.id.option_one);
        TextView optionTwo = findViewById(R.id.option_two);
        TextView optionThree = findViewById(R.id.option_three);
        TextView optionFour = findViewById(R.id.option_four);

        optionOne.setOnClickListener(this);
        optionTwo.setOnClickListener(this);
        optionThree.setOnClickListener(this);
        optionFour.setOnClickListener(this);
        Button submit_button = findViewById(R.id.button_submit);

        submit_button.setOnClickListener(this);

    }

    private void setQuestion() {

        Question question = initQuestionsList.get(initCurrPosition - 1);
        TextView optionOne = findViewById(R.id.option_one);
        TextView optionTwo = findViewById(R.id.option_two);
        TextView optionThree = findViewById(R.id.option_three);
        TextView optionFour = findViewById(R.id.option_four);
        Button submit_button = findViewById(R.id.button_submit);
        defaultOptionsView();

        if(initCurrPosition == initQuestionsList.size()) {

            submit_button.setText("FINISH");
        }

        else{
            submit_button.setText("SUBMIT");
        }

        ProgressBar progBar = findViewById(R.id.progress_bar);
        progBar.setProgress(initCurrPosition);

        TextView progText = findViewById(R.id.quiz_progress);
        progText.setText(initCurrPosition + "/" + progBar.getMax());

        TextView questionText = findViewById(R.id.music_question);
        questionText.setText(question.question);

        ImageView albumImage = findViewById(R.id.album_image);
        albumImage.setImageResource(question.image);

        optionOne.setText(question.optionOne);

        optionTwo.setText(question.optionTwo);

        optionThree.setText(question.optionThree);

        optionFour.setText(question.optionFour);

    }

    public void onClick(View v) {
        TextView optionOne = findViewById(R.id.option_one);
        TextView optionTwo = findViewById(R.id.option_two);
        TextView optionThree = findViewById(R.id.option_three);
        TextView optionFour = findViewById(R.id.option_four);
        Constants constants = new Constants();
        if(v.getId() == R.id.option_one) {
            selectedOptionView(optionOne, 1);
        }
        else if(v.getId() == R.id.option_two) {
            selectedOptionView(optionTwo, 2);
        }

        else if (v.getId() == R.id.option_three) {
            selectedOptionView(optionThree, 3);
        }

        else if (v.getId() == R.id.option_four) {
            selectedOptionView(optionFour, 4);
        }

        if (v.getId() == R.id.button_submit) {
            if(selectedOptionPosition == 0) {
                initCurrPosition ++;

                if(initCurrPosition <= initQuestionsList.size()) {
                    setQuestion();
                }
                else {
                    Intent intent = new Intent(this, resultactivity.class);
                    intent.putExtra(constants.USER_NAME, thisUsername);
                    intent.putExtra(constants.CORRECT_ANSWERS, correctAnswers);
                    intent.putExtra(constants.TOTAL_QUESTIONS, initQuestionsList.size());
                    startActivity(intent);

                }
            }
            else {
                Question question = initQuestionsList.get(initCurrPosition - 1);
                    if(question.correct != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg);

                    }
                    else {
                        correctAnswers++;
                    }
                    answerView(question.correct, R.drawable.correct_option_border_bg);


                if(initCurrPosition == initQuestionsList.size()) {
                    Button submit_button = findViewById(R.id.button_submit);
                    submit_button.setText("FINISH");
                }
                else {
                    Button submit_button = findViewById(R.id.button_submit);
                    submit_button.setText("NEXT QUESTION");
                }

                selectedOptionPosition = 0;
            }
        }


    }

    private void answerView(int ans, int drawableView) {
        TextView optionOne = findViewById(R.id.option_one);
        TextView optionTwo = findViewById(R.id.option_two);
        TextView optionThree = findViewById(R.id.option_three);
        TextView optionFour = findViewById(R.id.option_four);

        if(ans == 1) {
            optionOne.setBackground(ContextCompat.getDrawable(this, drawableView));

        }
        else if(ans == 2) {
            optionTwo.setBackground(ContextCompat.getDrawable(this, drawableView));
        }

        else if(ans == 3) {
            optionThree.setBackground(ContextCompat.getDrawable(this, drawableView));
        }

        else if(ans == 4) {
            optionFour.setBackground(ContextCompat.getDrawable(this, drawableView));
        }
    }

    private void selectedOptionView(TextView tv, int selectedOptionNum) {
        defaultOptionsView();
        selectedOptionPosition = selectedOptionNum;

        tv.setTextColor(Color.parseColor("#131314"));
        tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.select_option_border_bg));

    }

    private void defaultOptionsView() {
        ArrayList<TextView> options = new ArrayList<>();
        TextView optionOne = findViewById(R.id.option_one);
        TextView optionTwo = findViewById(R.id.option_two);
        TextView optionThree = findViewById(R.id.option_three);
        TextView optionFour = findViewById(R.id.option_four);

        options.add(0, optionOne);
        options.add(1, optionTwo);
        options.add(2, optionThree);
        options.add(3, optionFour);

        for (TextView option : options) {
            option.setTextColor(Color.parseColor("#828d9e"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }



    }
}