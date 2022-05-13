package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button startButton = findViewById(R.id.start_button);
        EditText entry = findViewById(R.id.entry);
        Constants constants = new Constants();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entry.getText().toString().isEmpty()) {
                    Toast.makeText(entry.getContext(), "Please enter your username",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(entry.getContext(), Questions_Activity.class);
                    intent.putExtra(constants.USER_NAME, entry.getText().toString());
                    startActivity(intent);
                    finish();
            }
            }

        });

    }
}