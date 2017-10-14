package com.example.nshas.guessinggame;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nshas on 10/13/2017.
 */

class MyButtonClickListener implements View.OnClickListener {

    //instantiates variables for button listener
    int randy, guess;
    int tries = 0;
    EditText guessEditText;
    String concatenatedText;

    //constructor
    public MyButtonClickListener(int randy, EditText guessEditText, int guess) {
        this.randy = randy;
        this.guessEditText = guessEditText;
        this.guess = guess;
    }

    @Override
    public void onClick(View v)
    {
        if(isEmpty(guessEditText))
        {
            concatenatedText = "Why, we must have a number to count! Ah-ah-ah!";
        }else{
            if(guess > randy)
            {
                tries++;
                concatenatedText = tries + " gueses! Ah-ah-ah! This is too high!";
            }else if(guess < randy){
                tries++;
                concatenatedText = tries + " gueses! Ah-ah-ah! This is too low!";
            }else if(guess == randy){
                tries++;
                concatenatedText = tries + " gueses! Ah-ah-ah! This is the number!";
                Intent resultIntent = new Intent(v.getContext(), ResultsActivity.class);
                resultIntent.putExtra("guess", guess);
                v.getContext().startActivity(resultIntent);
            }

        }

        Toast.makeText(v.getContext(), concatenatedText, Toast.LENGTH_SHORT).show();

    }

    //checks if isEmpty
    private boolean isEmpty(EditText editText)
    {
        return editText.getText().toString().trim().length() == 0;
    }


}
