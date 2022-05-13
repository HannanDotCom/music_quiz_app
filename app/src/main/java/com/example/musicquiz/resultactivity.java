package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        Constants constants = new Constants();

        String username = getIntent().getStringExtra(constants.USER_NAME);
        TextView tvUsername = findViewById(R.id.username);
        tvUsername.setText(username);

        int totalQs = getIntent().getIntExtra(constants.TOTAL_QUESTIONS,0);
        int correctAns = getIntent().getIntExtra(constants.CORRECT_ANSWERS,0);

        TextView score = findViewById(R.id.score);

        score.setText("Your score is " + correctAns + " out of " + totalQs);

        Button end_button = findViewById(R.id.finish);

        end_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(end_button.getContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}