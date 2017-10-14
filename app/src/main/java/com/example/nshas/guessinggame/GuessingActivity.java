package com.example.nshas.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class GuessingActivity extends AppCompatActivity
{

    //instantiate random number var
    int randy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        randy = new Random().nextInt(21);

        //EditText for number
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        int guess = Integer.parseInt(guessEditText.getText().toString());
        //EditText countMessage = (EditText) findViewById(R.id.countMessage);

        //call listener
        View view = findViewById(R.id.checkNum);
        MyButtonClickListener listener = new MyButtonClickListener(randy, guessEditText, guess);
        view.setOnClickListener(listener);

    }
}
