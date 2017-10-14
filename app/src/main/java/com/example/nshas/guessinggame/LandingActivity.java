package com.example.nshas.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button startGame = (Button) findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LandingActivity.this, GuessingActivity.class);
                startActivity(intent);
            }
        });

    }
}
