package com.example.nshas.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessingActivity extends AppCompatActivity
{

    //instantiate random number var
    int randy;
    Random randall;
    TextView debugHint;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        randall = new Random();
        randy = randall.nextInt((20-0)+1);

        //EditText for number
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        TextView debugHint = (TextView) findViewById(R.id.debugHint);
        debugHint.setText("Debug Hint: " + String.valueOf(randy));
        //int guess = Integer.parseInt(guessEditText.getText().toString());
        //EditText countMessage = (EditText) findViewById(R.id.countMessage);

        //call listener
        View view = findViewById(R.id.checkNum);
        MyButtonClickListener listener = new MyButtonClickListener(randy, guessEditText);
        view.setOnClickListener(listener);

    }
}
