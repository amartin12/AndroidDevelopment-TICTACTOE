package edu.quinnipiac.ser210.assign1tictactoe;

import android.app.Activity;

import java.util.Random;

public class TicTacToe extends Activity implements ITicTacToe {

    // Instance variables
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    Random random = new Random(); //Random number to be used when computer makes a random move
    boolean human, computer; // keep track on human vs computer
    public int human_player; // keeps track of human player X or O
    public int playerSymbol = CROSS; // human player symbol
    public int computerSymbol = NOUGHT; // computer player symbol
    int computer_row; // track the computer row
    int computer_column; // track the computer column

    /**
     * clear board and set current player
     */
    public TicTacToe() {
        //TODO
    }

    @Override
    public void clearBoard() {
        //loop through all the rows and columns on the board
        for(int row = 0; row<3; row++){
            for(int column = 0; column<3; column++){
                board[row][column]=0;
            }
        }
    }

    public int getComputer_row(){
        return computer_row;
    }

    public int getComputer_column(){
        return computer_column;
    }

    public boolean getHuman(){
        return human;
    }

    public boolean getComputer(){
        return computer;
    }

    public int getBoardPosition(int row, int column){
        return board[row][column];
    }
    //Method to move the human player game piece
    @Override
    public void setMove(int player, int location) {

        // if else to determine what game piece the human player is
        if(player ==CROSS) {
            human_player = CROSS;
        }
        else if(player ==NOUGHT) {
            human_player = NOUGHT;
        }
        else
            human_player = EMPTY;


        //switch statement to determine the which location to put the human's game piece
        switch (location) {
            // top left spot 0
            case 0:
                if(board[0][0]==EMPTY) {
                    board[0][0] = human_player;
                }
                break;
            // top row middle spot 1
            case 1:
                if(board[0][1]==EMPTY) {
                    board[0][1] =human_player;
                }
                break;
            //top row right spot 2
            case 2:
                if(board[0][2]==EMPTY) {
                    board[0][2] = human_player;
                }
                break;
            //middle row first spot 3
            case 3:
                if(board[1][0]==EMPTY){
                    board[1][0] = human_player;
                }
                break;
            //middle row  middle spot 4
            case 4:
                if(board[1][1]==EMPTY) {
                    board[1][1] = human_player;
                }
                break;
            //middle row  last spot 5
            case 5:
                if(board[1][2]==EMPTY) {
                    board[1][2] = human_player;
                }
                break;
            //bottom row  first spot 6
            case 6:
                if(board[2][0]==EMPTY) {
                    board[2][0] = human_player;
                }
                break;
            //bottom row  middle spot 7
            case 7:
                if(board[2][1]==EMPTY) {
                    board[2][1] = human_player;
                }
                break;
            // bottom row  last spot 8
            case 8:
                if(board[2][2]==EMPTY){
                    board[2][2] = human_player;
                }
                break;
            default:
                System.out.println("Please Enter Open Space");

                break;
        }
    }
    @Override
    // Method to get the move the computer will make
    public int getComputerMove() {
        // local variables
        computer_row =2;
        computer_row =2;
        computer =false;
        int computer_player; // computers game piece
        int row_computer = 2; // row number to use to help calculate a random move when computer does not block
        int col_computer = 2; // column number to use to help calculate a random move when computer does not block


        //if statement to get determine what piece the
        if(human_player==CROSS) {
            computer_player=NOUGHT;
        }else
            computer_player= CROSS;


        // LEFT Diagonal COMPUTER BLOCK
        //down spot 0 -8
        if(board[0][0] == human_player && board[1][1] ==human_player && board[2][2] ==EMPTY ) {
            board[2][2] = computer_player;
            computer_row = 2;
            computer_column = 2;
            computer =true;
        }
        //// up spots 8-0
        else if(board[2][2] == human_player && board[1][1] ==human_player && board[0][0] ==EMPTY ) {
            board[0][0] = computer_player;
            computer_row = 0;
            computer_column = 0;
            computer =true;
        }
        //RIGHT Diagonal COMPUTER BLOCK
        // down spot 2-6
        else if(board[0][2] == human_player && board[1][1] ==human_player && board[2][0] ==EMPTY ) {
            board[2][0] = computer_player;
            computer_row = 2;
            computer_column = 0;
            computer =true;
        }
        //up 6-2
        else if(board[2][0] == human_player && board[1][1] ==human_player && board[0][2] ==EMPTY ) {
            board[0][2] = computer_player;
            computer_row = 0;
            computer_column = 2;
            computer =true;
        }

        //ROW BLOCKS
        //Top row spots 0 -2
        else if(board[0][0] ==human_player && board[0][1] ==human_player && board[0][2] ==EMPTY ) {
            board[0][2] = computer_player;
            computer_row = 0;
            computer_column = 2;
        }
        // top 2-0
        else if(board[0][2] == human_player && board[0][1] ==human_player && board[0][0] ==EMPTY ) {
            board[0][0] = computer_player;
            computer_row = 0;
            computer_column = 0;
            computer =true;
        }

        //Middle row 3-5
        else if(board[1][0] == human_player && board[1][1] ==human_player && board[1][2] ==EMPTY ) {
            board[1][2] = computer_player;
            computer_row = 1;
            computer_column = 2;
            computer =true;
        }
        // middle 5-3
        else if(board[1][2] == human_player && board[1][1] ==human_player && board[1][0] ==EMPTY ) {
            board[1][0] = computer_player;
            computer_row = 1;
            computer_column = 0;
            computer =true;
        }
        //Bottom
        else if(board[2][0] ==human_player && board[2][1] ==human_player && board[2][2] ==EMPTY ) {
            board[2][2] = computer_player;
            computer_row = 2;
            computer_column = 2;
            computer =true;
        }
        else if(board[2][2] ==human_player && board[2][1] ==human_player && board[2][0] ==EMPTY ) {
            board[2][0] = computer_player;
            computer_row = 2;
            computer_column = 0;
            computer =true;
        }
        //COLUMN BLOCK left to right
        //
        else if(board[0][0] == human_player && board[1][0] ==human_player && board[0][0] ==EMPTY ) {
            board[2][0] = computer_player;
            computer_row = 2;
            computer_column = 0;
            computer =true;

        }
        else if(board[2][0] == human_player && board[1][0] ==human_player && board[0][0] ==EMPTY ) {
            board[0][0] = computer_player;
            computer_row = 0;
            computer_column = 0;
            computer =true;
        }
        //2
        else if(board[0][1] == human_player && board[1][1] ==human_player && board[2][1] ==EMPTY ) {
            board[2][1] = computer_player;
            computer_row = 2;
            computer_column = 1;
            computer =true;
        }
        else if(board[2][1] == human_player && board[1][1] ==human_player && board[0][1] ==EMPTY ) {
            board[0][1] = computer_player;
            computer_row = 0;
            computer_column = 1;
            computer =true;
        }
        //3
        else if(board[0][2] == human_player && board[1][2] ==human_player && board[2][2] ==EMPTY ) {
            board[2][2] = computer_player;
            computer_row = 2;
            computer_column = 2;
            computer =true;
        }
        else if(board[2][2] == human_player && board[1][2] ==human_player && board[0][2] ==EMPTY ) {
            board[0][2] = computer_player;
            computer_row = 0;
            computer_column = 2;
            computer =true;
        }
        //Default to making random board moves for the computer
        else {
            row_computer = (int)(Math.random()*2);// random row
            col_computer = (int)(Math.random()*2); // random col
            board[row_computer][col_computer]=computer_player;	// set board to those rows
        }
        return 0;
    }


    //Method to check status of players to check if there is a win
    // the if statements check if the boards game pieces match
    @Override
    public int checkForWinner() {
        //local variable
        int player_Win=PLAYING; // uses status of playing
        int board_full = 0; // variable used when looking to see if board is full


        //ROW WINS
        //TOP Row WIN spots 0-2
        if(board[0][0]!=EMPTY&& board[0][0] == board[0][1] && board[0][1]==board[0][2]&& board[0][0]==board[0][2]) {
            if(board[0][0]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][0]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //MIDDLE Row WIN spots 3-5
        if(board[1][0]!=EMPTY&&board[1][0] == board[1][1] && board[1][0]==board[1][2]&& board[1][1]==board[1][2]) {
            if(board[1][0]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[1][0]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //BOTTOM Row WIN spots 6-8
        if(board[2][0]!=EMPTY&&board[2][0] == board[2][1] && board[2][0]==board[2][2]&& board[2][1]==board[2][2]) {
            if(board[2][0]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[2][0]==CROSS) {
                player_Win = CROSS_WON;
            }
        }
        //COLUMN WINS

        //Left COLUMN WIN spots: 0, 3, 6
        if(board[0][0]!=EMPTY&&board[0][0] == board[1][0] && board[0][0]==board[2][0]&& board[1][0]==board[2][0]) {
            if(board[0][0]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][0]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //MIDDLE COLUMN WIN spots: 1,4,7
        if(board[0][1]!=EMPTY&&board[0][1] == board[1][1] && board[0][1]==board[2][1]&& board[1][1]==board[2][1]) {
            if(board[0][1]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][1]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //RIGHT COLUMN WIN spots: 2,5,8
        if(board[0][2]!=EMPTY&&board[0][2] == board[1][2] && board[0][2]==board[2][2]&& board[1][2]==board[2][2]) {
            if(board[0][2]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][2]==CROSS) {
                player_Win = CROSS_WON;
            }
        }
        //DIAGONAL WINS

        //LEFT DIAGONAL WIN spots: 0,4,8
        if(board[0][0]!=EMPTY&&board[0][0] == board[1][1] && board[0][0]==board[2][2]&& board[1][1]==board[2][2]) {
            if(board[0][0]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][0]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //RIGHT DIAGONAL WIN spots: 2,4,6
        if(board[0][2]!=EMPTY&&board[0][2] == board[1][1] && board[0][2]==board[2][0] &&board[1][1]==board[2][0]) {
            if(board[0][2]==NOUGHT) {
                player_Win = NOUGHT_WON;
            }else if (board[0][2]==CROSS) {
                player_Win = CROSS_WON;
            }
        }

        //For loop to check the row and columns if the b
        for(int row = 0; row<3; row++) {
            for(int col = 0; col<3; col++){
                if(board[row][col]!=EMPTY) {
                    board_full++;
                }
            }
        }

        if(board_full==9) { // board is 9 spaces counting from 0-8 counting the 0
            player_Win = TIE;
        }
        //will return the player who won.
        return player_Win;
    }

    /**
     * Given
     * Print the game board
     */
    public void printBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                printCell(board[row][col]); // print each of the cells
                if (col != COLS - 1) {
                    System.out.print("|"); // print vertical partition
                }
            }
            System.out.println();
            if (row != ROWS - 1) {
                System.out.println("-----------"); // print horizontal partition
            }
        }
        System.out.println();
    }

    /**
     * Print a cell with the specified "content"
     *
     * @param content
     *            either CROSS, NOUGHT or EMPTY
     */
    public void printCell(int content) {
        switch (content) {
            case EMPTY:
                System.out.print("   ");
                break;
            case NOUGHT:
                System.out.print(" O ");
                break;
            case CROSS:
                System.out.print(" X ");
                break;
        }
    }

}
