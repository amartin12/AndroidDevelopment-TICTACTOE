package edu.quinnipiac.ser210.assign1tictactoe;

/*
Author: Alexandra Martin
Professor Ruby
SER 210 Android Development
14 Feb 2020
TicTacToe Splash Screen class

Sets up the opening screen for the user to enter their name and give instructions for the game
 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }
        //Call onSendName() when the button is clicked
    public void onSendName(View view) {

        EditText nameView = (EditText) findViewById(R.id.name);// get the name of the user
         String nameText = nameView.getText().toString();

        Intent intent = new Intent(this, MainActivity.class); // will send to the main activity class to display a welcome message

        intent.putExtra(MainActivity.PLAYER_NAME, nameText); // create and intent and then add the name to the intent
        startActivity(intent);
        }



}
