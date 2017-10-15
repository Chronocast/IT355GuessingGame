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
    public MyButtonClickListener(int randy, EditText guessEditText) {
        this.randy = randy;
        this.guessEditText = guessEditText;
        //this.guess = guess;
    }

    @Override
    public void onClick(View v)
    {
        if(isEmpty(guessEditText))
        {
            concatenatedText = "Why, we must have a number to count! Ah-ah-ah!";
        }else{
            guess = Integer.parseInt(guessEditText.getText().toString());
            if(guess > randy)
            {
                tries++;
                concatenatedText = tries + " guesses! Ah-ah-ah! This is too high!";
            }else if(guess < randy){
                tries++;
                concatenatedText = tries + " guesses! Ah-ah-ah! This is too low!";
            }else if(guess == randy){
                tries++;
                concatenatedText = tries + " guesses! Ah-ah-ah! This is the number!";
                Intent resultIntent = new Intent(v.getContext(), ResultsActivity.class);
                String attempts = "" + tries;
                resultIntent.putExtra("GUESSES", attempts);
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
