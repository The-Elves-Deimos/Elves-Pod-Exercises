package eduardo.week2.TicTacToe;

import java.util.Scanner;
import java.lang.Math;

public class ticTacToe {
    private static Scanner sc = new Scanner(System.in);
    private static int gamesTie = 0;


    public static void game(){
        System.out.println("Welcome to Tic Tac Toe");
        Player[] players = new Player[2];
        int games = 0;
        boolean response;
        String[][] matrix = {
                {"---", "---", "---"},
                {"---", "---", "---"},
                {"---", "---", "---"}
        };

        do{
            players = match(matrix, players, games);

            System.out.println("\nHere are your statistics: ");
            System.out.printf("%s has %d games won%n", players[0].getName(), players[0].getGamesWon());
            System.out.printf("%s has %d games won%n", players[1].getName(), players[1].getGamesWon());
            System.out.printf("And both have tied in %d matches.%n%n", getGamesTie());

            System.out.println("Do you want to play another game of Tic Tac Toe? (Y/N)");
            String another = sc.nextLine();
            another = another.trim();

            if(another.equalsIgnoreCase("y") || another.equalsIgnoreCase("yes")){
                response = true;
                games++;
            }else {
                response = false;
                System.out.println("This was fun guys...thanks for playing....");
                games = 0;
            }

        }while(response);
    }

    //method that run the match between two players
//    private static Player[] match(String[][] arr){
//        Player[] players = new Player[2];
//        String checkX = "-x-";
//        String checkO = "-o-";
//        boolean isOver;
//        //random number to check which player starts the game
//        int turn = (int)(Math.random() * ((2 - 1) + 1)) + 1;
//
//        System.out.println("Please enter the name for player 1:");
//        String playerOne = sc.nextLine();
//        playerOne = playerOne.trim();
//        Player player1 = new Player(playerOne);
//
//        System.out.println("Please enter the name for player 2:");
//        String playerTwo = sc.nextLine();
//        playerTwo = playerTwo.trim();
//        Player player2 = new Player(playerTwo);
//
//        System.out.printf("Looks like we have %s and %s today for a match of Tic Tae Toe..%n", player1.getName(), player2.getName());
//        System.out.printf("All right %s....you will be the x...%n", player1.getName());
//        System.out.printf("and of course that means... %s....you will be the o...%n", player2.getName());
//        displayMoves(arr);
//
//        do{
//            //player one plays it turns when turn is equal to one
//            if(turn == 1){
//                System.out.printf("%n%s enter your move....", player1.getName());
//                checkMove(arr,checkX);
//                displayMoves(arr);
//                isOver = checkWin(arr, checkX, player1);
//                //changes turn to 2 for player 2 to make a move
//                turn = 2;
//            }else{
//                //turns is equal to two for player 2 to make a move
//                System.out.printf("%n%s enter your move....", player2.getName());
//                checkMove(arr,checkO);
//                displayMoves(arr);
//                isOver = checkWin(arr, checkO, player2);
//                //changes turn to 1 for player 1 to make a move
//                turn = 1;
//            }
//
//        }while(!isOver);
//
//        players[0] = player1;
//        players[1] = player2;
//
//        return players;
//    }

    //method that run the match between two players
    private static Player[] match(String[][] arr, Player[] players, int counter){
        String checkX = "-x-";
        String checkO = "-o-";
        boolean isOver;
        Player player1;
        Player player2;
        //random number to check which player starts the game
        int turn = (int)(Math.random() * ((2 - 1) + 1)) + 1;

        if (counter == 0) {
            System.out.println("Please enter the name for player 1:");
            String playerOne = sc.nextLine();
            playerOne = playerOne.trim();
            player1 = new Player(playerOne);

            System.out.println("Please enter the name for player 2:");
            String playerTwo = sc.nextLine();
            playerTwo = playerTwo.trim();
            player2 = new Player(playerTwo);

            System.out.printf("Looks like we have %s and %s today for a match of Tic Tae Toe..%n", player1.getName(), player2.getName());
            System.out.printf("All right %s....you will be the x...%n", player1.getName());
            System.out.printf("and of course that means... %s....you will be the o...%n", player2.getName());

        }else{
            player1 = players[0];
            player2 = players[1];

            System.out.printf("Looks like we have %s and %s today for a re-match of Tic Tae Toe..%n", player1.getName(), player2.getName());
            System.out.printf("All right %s....you will still be the x...%n", player1.getName());
            System.out.printf("and of course that means... %s....you still will be the o...%n", player2.getName());
        }

        displayMoves(arr);

        do{
            //player one plays it turns when turn is equal to one
            if(turn == 1){
                System.out.printf("%n%s enter your move....", player1.getName());
                checkMove(arr,checkX);
                displayMoves(arr);
                isOver = checkWin(arr, checkX, player1);
                //changes turn to 2 for player 2 to make a move
                turn = 2;
            }else{
                //turns is equal to two for player 2 to make a move
                System.out.printf("%n%s enter your move....", player2.getName());
                checkMove(arr,checkO);
                displayMoves(arr);
                isOver = checkWin(arr, checkO, player2);
                //changes turn to 1 for player 1 to make a move
                turn = 1;
            }

        }while(!isOver);

        players[0] = player1;
        players[1] = player2;

        return players;
    }

    //method that checks if a move made by a player is valid
    private static void checkMove(String[][] arr, String mark){
        //array of possible moves allowed based on the matrix
        String[] possibleMoves = {"1A", "1B", "1C", "2A", "2B", "2C", "3A", "3B", "3C"};
        String move = sc.nextLine();
        move = move.trim().toUpperCase();
        boolean possible = false;

        //compare player selected move into the array of possible moves
        for(String oneMove : possibleMoves){
            if(move.equals(oneMove)){
                possible = true;
                break;
            }
        }

        //checks if the move is allowed and no other player has his mark on the same spot
        if(possible && checkSpace(move,arr)){
            changeMove(move, arr, mark);
        }else{
            //recurse the method if invalid move
            System.out.println("Not a correct move...Try again...");
            checkMove(arr,mark);
        }

    }

    //method that changes a spot in the array with the player mark if the move is valid
    private static void changeMove(String move, String[][] arr, String mark){
        switch (move){
            case "1A":
                arr[0][0] = mark;
                break;
            case "1B":
                arr[0][1] = mark;
                break;
            case "1C":
                arr[0][2] = mark;
                break;
            case "2A":
                arr[1][0] = mark;
                break;
            case "2B":
                arr[1][1] = mark;
                break;
            case "2C":
                arr[1][2] = mark;
                break;
            case "3A":
                arr[2][0] = mark;
                break;
            case "3B":
                arr[2][1] = mark;
                break;
            case "3C":
                arr[2][2] = mark;
                break;
        }

    }

    //method that checks if no other player has his mark in a spot
    private static boolean checkSpace(String move, String[][] arr){
        boolean canYou = true;

        switch (move){
            case "1A":
                if( arr[0][0].equals("-x-") || arr[0][0].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "1B":
                if( arr[0][1].equals("-x-") || arr[0][1].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "1C":
                if( arr[0][2].equals("-x-") || arr[0][2].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "2A":
                if( arr[1][0].equals("-x-") || arr[1][0].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "2B":
                if( arr[1][1].equals("-x-") || arr[1][1].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "2C":
                if( arr[1][2].equals("-x-") || arr[1][2].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "3A":
                if( arr[2][0].equals("-x-") || arr[2][0].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "3B":
                if( arr[2][1].equals("-x-") || arr[2][1].equals("-o-") ){
                    canYou = false;
                }
                break;
            case "3C":
                if( arr[2][2].equals("-x-") || arr[2][2].equals("-o-") ){
                    canYou = false;
                }
                break;
        }

        return canYou;
    }

    //method that checks if a player win the game after a move.
    private static boolean checkWin(String[][] arr, String mark, Player player){
        boolean win = false;
        int counter = 0;

        String winMark;

        //special mark for when a player wins the game
        if(mark.equals("-x-")){
            winMark = "*x*";
        }else {
            winMark = "*o*";
        }

        if(arr[0][0].equals(mark) && arr[0][1].equals(mark) && arr[0][2].equals(mark)){
            win = true;
            arr[0][0] = winMark;
            arr[0][1] = winMark;
            arr[0][2] = winMark;
        }else if(arr[1][0].equals(mark) && arr[1][1].equals(mark) && arr[1][2].equals(mark)){
            win = true;
            arr[1][0] = winMark;
            arr[1][1] = winMark;
            arr[1][2] = winMark;
        }else if(arr[2][0].equals(mark) && arr[2][1].equals(mark) && arr[2][2].equals(mark)) {
            win = true;
            arr[2][0] = winMark;
            arr[2][1] = winMark;
            arr[2][2] = winMark;
        }else if(arr[0][0].equals(mark) && arr[1][0].equals(mark) && arr[2][0].equals(mark)){
            win = true;
            arr[0][0] = winMark;
            arr[1][0] = winMark;
            arr[2][0] = winMark;
        }else if(arr[0][1].equals(mark) && arr[1][1].equals(mark) && arr[2][1].equals(mark)) {
            win = true;
            arr[0][1] = winMark;
            arr[1][1] = winMark;
            arr[2][1] = winMark;
        }else if(arr[0][2].equals(mark) && arr[1][2].equals(mark) && arr[2][2].equals(mark)){
            win = true;
            arr[0][2] = winMark;
            arr[1][2] = winMark;
            arr[2][2] = winMark;
        }else if(arr[0][0].equals(mark) && arr[1][1].equals(mark) && arr[2][2].equals(mark)){
            win = true;
            arr[0][0] = winMark;
            arr[1][1] = winMark;
            arr[2][2] = winMark;
        }else if(arr[0][2].equals(mark) && arr[1][1].equals(mark) && arr[2][0].equals(mark)){
            win = true;
            arr[0][2] = winMark;
            arr[1][1] = winMark;
            arr[2][0] = winMark;
        }

        //checks if all spots are filled
        for(int x = 0; x < arr.length; x++){
            for(int y =0; y < arr.length; y++){
                if(arr[x][y].equals("-x-") || arr[x][y].equals("-o-")){
                    counter++;
                }
            }

        }

        //if all spots are full return win as positive to end the match
        if(counter == 9){
            win = true;
        }

        if(win){
            //displays array with winning marks
            displayMoves(arr);

            if(counter != 9){
                System.out.printf("%nCongratulations %s, you won the match.......%n", player.getName());
                player.playerWon();
            }else{
                System.out.println("\nLooks like we have a tie match......");
                gamesTie++;
            }

            //sets array back to blank for another game
            for(int x = 0; x < arr.length; x++){
                for(int y =0; y < arr.length; y++){
                    arr[x][y] = "---";
                }
            }
        }

        return win;
    }

    //function that displays the array with current moves.
    private static void displayMoves(String[][] arr){
        System.out.println("   A   B   C");

        for(int x = 0; x < arr.length; x++){
            System.out.printf("%d ", x+1);
            for(int y =0; y < arr.length; y++){
                System.out.printf("%3s ", arr[x][y]);
            }
            System.out.println();
        }
    }

    public static int getGamesTie(){
        return gamesTie;
    }
}
