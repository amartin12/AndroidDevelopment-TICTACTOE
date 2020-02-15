package edu.quinnipiac.ser210.assign1tictactoe;

/*
Author: Alexandra Martin
Professor Ruby
SER 210 Android Development
14 Feb 2020
TicTacToe Main Activity class

Sets the game player and buttons of the game. Is where the game plays.
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_NAME = "welcome"; // passing player name value to welcome screen
    int computer_row;
    int computer_column;
    private TicTacToe board = new TicTacToe();
    private int currentState = ITicTacToe.PLAYING;
    Button human_button;
    Button computer_button;
    Random random = new Random(); //Random number to be used when computer makes a random move
    public int human_player; // keeps track of human player X or O
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8;
    Button[] buttonArray;
    boolean turn = true;
    Boolean human_move, computer_move;
    //public int human_player;
    int turn_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent(); // get the intent
        String nameText = intent.getStringExtra(PLAYER_NAME); // get the player name
        TextView nameView = (TextView) findViewById(R.id.weclome); //welcome message for splash screen
        nameView.setText("Welcome to Tic Tac Toe " + nameText); // Get the name of player and sets in main activity

        //setting all the buttons with their ids in from the xml to link together
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        //adding all the buttons to the array
        buttonArray = new Button[]{button0,button1,button2,button3,button4,button5,button6,button7,button8};
        //for loop to add a click listener to all the buttons
        for(Button b: buttonArray){
            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   // toast("Button Clicked");
                    Button b = (Button) v;
                    clickedButton(b); // call clicked button
                }
            });

        }

    }
    //for button click to set the text
    public void clickedButton(Button button){

        if(turn){
            //X
            button.setText("X");

        }else{
            //O
            button.setText("O");
        }
        turn_count++;

        button.setBackgroundColor(Color.YELLOW);
        button.setClickable(false);
        //change turn
        turn = !turn;

        checkForWinner();

    }
    // onclick method for the reset button
    public void resetGame(View view){
        turn = true;
        turn_count =0;
        enabledisableAllButtons(true);

    }
        //method for the game move to set the player positions
        public void gameMove(View view) {
        if (currentState == ITicTacToe.PLAYING) {
            int position = 9;
            switch (view.getId()) {
                case R.id.button0:
                    position = 0;
                    human_button = (Button) view;
                    break;
                case R.id.button1:
                    position = 1;
                    human_button = (Button) view;
                    break;
                case R.id.button2:
                    position = 2;
                    human_button = (Button) view;
                    break;

                case R.id.button3:
                    position = 3;
                    human_button = (Button) view;
                    break;

                case R.id.button4:
                    position = 4;
                    human_button = (Button) view;
                    break;

                case R.id.button5:
                    position = 5;
                    human_button = (Button) view;
                    break;

                case R.id.button6:
                    position = 6;
                    human_button = (Button) view;
                    break;

                case R.id.button7:
                    position = 7;
                    human_button = (Button) view;
                    break;

                case R.id.button8:
                    position = 8;
                    human_button = (Button) view;
                    break;
            }
            board.setMove(0, position);
            if (board.getHuman()) {
                human_button.setText("X");
                human_button.setBackgroundColor(Color.YELLOW);
                board.printBoard();
            }
            checkForWinner();
        }
        //checking current state of game
        if (currentState == ITicTacToe.PLAYING) {
            board.getComputerMove();
            if (board.getComputer()) {
                computer_row = board.getComputer_row();
                computer_column = board.getComputer_column();
                computer_button.setText("O");
                computer_button.setBackgroundColor(Color.YELLOW);
                board.printBoard();
            }
            checkForWinner();
        }

    }
    private void checkForWinner(){

        boolean is_winner = false;

        if(button0.getText() == button1.getText() && button1.getText() == button2.getText() && !button0.isClickable())
            is_winner = true;

        else if(button3.getText() == button4.getText() && button1.getText() == button5.getText()&& !button3.isClickable())
            is_winner = true;

        else if(button6.getText() == button7.getText() && button7.getText() == button8.getText()&& !button6.isClickable())
            is_winner = true;

//        // vertical
        else if(button0.getText() == button3.getText() && button3.getText() == button6.getText()&& !button0.isClickable())
            is_winner = true;

        else if(button1.getText() == button4.getText() && button4.getText() == button7.getText()&& !button4.isClickable())
            is_winner = true;

        else if(button2.getText() == button5.getText() && button5.getText() == button8.getText()&& !button8.isClickable())
            is_winner = true;


//        // diagonal
        else if(button0.getText() == button4.getText() && button4.getText() == button8.getText()&& !button0.isClickable())
            is_winner = true;

        else if(button2.getText() == button4.getText() && button4.getText() == button6.getText()&& !button4.isClickable())
            is_winner = true;

//      //if there is a winner set the toast messages
        if(is_winner){

            if(!turn){
                toast("X WINS");
            }else{
                toast("O WINS");
            }
            //enable and disable buttons
            enabledisableAllButtons(false);

        }
        else if(turn_count == 9)
        { // board is full
            toast("There is a TIE");
        }
    }
    //Method to enable to disable buttons from being clicked
    private void enabledisableAllButtons(boolean enable) {
        //false to disable
        //for loop to loop through button array
        for(Button b: buttonArray){
            b.setClickable(enable);
            //if buttons are enable set the color
            if(enable) {
                b.setBackgroundColor(Color.parseColor("33b5e5"));
                b.setText("");
            }
            else
                b.setBackgroundColor(Color.LTGRAY);
        }
    }

//    private void enabledisableResetButton(boolean enable){
//
//        reset.setClickable(enable);
//
//    }
    //Toast to have popup message appear when call toast
    private void toast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }


}
