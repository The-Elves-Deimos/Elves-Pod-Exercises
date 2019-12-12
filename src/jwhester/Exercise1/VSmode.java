package jwhester.Exercise1;

import java.util.Scanner;

public class VSmode{
    public static void VSrun() {
        int sticks = 21;
        int numToTake;
        Scanner take = new Scanner(System.in);
        Scanner player1 = new Scanner(System.in);
        Scanner player2 = new Scanner(System.in);
        System.out.println("Player 1 enter your name:");
        String play1 = player1.nextLine();
        System.out.println("Player 2 enter your name:");
        String play2 = player2.nextLine();
        while (sticks > 0) {
            System.out.printf("%s goes next.%n",play1);
            System.out.println("How many sticks do you want to take? (1 or 2)");
            numToTake = take.nextInt();
            while (numToTake > 2 || numToTake < 1) {
                System.out.println("Please pick 1 or 2:");
                numToTake = take.nextInt();
            }
            sticks = sticks - numToTake;
            System.out.printf("%s took %d sticks. There are %d sticks left.%n",play1, numToTake, sticks);
            if (sticks <= 0) {
                System.out.printf("%s loses!",play1);
            }
            System.out.printf("%s goes next.%n",play2);
            System.out.println("How many sticks do you want to take? (1 or 2)");
            numToTake = take.nextInt();
            while (numToTake > 2 || numToTake < 1) {
                System.out.println("Please pick 1 or 2:");
                numToTake = take.nextInt();
            }
            sticks = sticks - numToTake;
            System.out.printf("%s took %d sticks. There are %d sticks left.%n",play2, numToTake, sticks);
            if (sticks <= 0) {
                System.out.printf("%s loses!",play2);


            }
        }
    }
}
