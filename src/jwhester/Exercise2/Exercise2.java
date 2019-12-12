package jwhester.Exercise2;
import java.util.Random;
import java.util.Scanner;
public class Exercise2 {
    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";

    public static String getUsersMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move: ");
        String input = scanner.next().toUpperCase();
        return input;
    }

    public static String getComputersMove() {
        int computersNum;
        String computersMove = "";
        Random random = new Random();
        computersNum = random.nextInt(3) + 1;
        if (computersNum == 1)
            computersMove = ROCK;
        else if (computersNum == 2)
            computersMove = PAPER;
        else if (computersNum == 3)
            computersMove = SCISSORS;

        return computersMove;
    }


    public static void getResult(String usersMove, String computersMove) {

        System.out.println("Computer's move is: " + computersMove);

        if (usersMove.equals(computersMove))
            System.out.println("It's a tie!");
        else if (usersMove.equals(ROCK)) {
            if (computersMove.equals(SCISSORS))
                System.out.println("You win!! Rock breaks scissors.");
            else if (computersMove.equals(PAPER))
                System.out.println("You lose!! Paper covers rock.");
        } else if (usersMove.equals(PAPER)) {
            if (computersMove.equals(ROCK))
                System.out.println("You win!! Paper covers rock.");
            else if (computersMove.equals(SCISSORS))
                System.out.println("You lose!! Scissor cuts paper.");
        } else if (usersMove.equals(SCISSORS)) {
            if (computersMove.equals(PAPER))
                System.out.println("You win!! Scissor cuts paper.");
            else if (computersMove.equals(ROCK))
                System.out.println("You lose!! Rock breaks scissors.");
        } else
            System.out.println("Invalid user input.");
    }




    public static void main(String[] args) {
            System.out.println("Rock, Paper, Scissors!\n"
                    + "Please enter a move.\n"
                    + "Rock = R, Paper= P, and Scissors = S.\n");
            System.out.println(
                    "    _______\n" +
                    "---'   ____)\n" +
                    "      (_____)\n" +
                    "    R (_____)\n" +
                    "      (____)\n" +
                    "---.__(___)\n");
            System.out.println(
                    "    _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "     P    _______)\n" +
                    "         _______)\n" +
                    "---.__________)");
            System.out.println(
                    "    _______\n" +
                    "---'   ____)____\n" +
                    "          ______)\n" +
                    "     S __________)\n" +
                    "      (____)\n" +
                    "---.__(___)");

            String userInput = getUsersMove();
            if (userInput.equals(PAPER) || userInput.equals(ROCK) || userInput.equals(SCISSORS)) {
                getResult(userInput, getComputersMove());
                System.out.println("Play again? (y/n)");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next().toUpperCase();
                if (input.equals("Y")) {
                    main(args);
                } else if (input.equals("N")){
                    System.exit(0);
                } else {
                    System.out.println("Invalid Input " + input);
                    System.exit(0);
                }
            } else {
                System.out.println("Invalid Input " + userInput);
                main(args);
            }
    }
}