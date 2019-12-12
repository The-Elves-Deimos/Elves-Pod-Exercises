package jwhester.Exercise1;

import java.util.Scanner;

public class HardMode extends VSmode {
    public static void HardRun() {
        int sticks = 21;
        int numToTake;
        boolean random = Math.random() < 0.5;
        Scanner take = new Scanner(System.in);
        while (sticks > 0) {
            if ((random)) {
                System.out.println("Player goes next.");
                System.out.println("How many sticks do you want to take? (1 or 2)");
                numToTake = take.nextInt();
                while (numToTake > 2 || numToTake < 1) {
                    System.out.println("Please pick 1 or 2:");
                    numToTake = take.nextInt();
                }
                sticks = sticks - numToTake;
                System.out.printf("You took %d sticks. There are %d sticks left.%n", numToTake, sticks);
                if (sticks <= 0) {
                    System.out.println("You lose!");
                } else {
                    //if taking two sticks makes computer lose the game, or if taking two sticks leaves some multiple of three left, then only take one, otherwise take two.
                    if ((sticks - 2) % 3 == 0 || sticks - 2 == 0) {
                        numToTake = 1;
                    } else {
                        numToTake = 2;
                    }
                    sticks = sticks - numToTake;
                    System.out.printf("Computer takes %d sticks. There are %d sticks left.%n", numToTake, sticks);
                    if (sticks <= 0) {
                        System.out.println("You win!");
                    }

                }
            } else {
                System.out.println("Computer goes next.");
                if ((sticks - 2) % 3 == 0 || sticks - 2 == 0) {
                    numToTake = 1;
                } else {
                    numToTake = 2;
                }
                sticks = sticks - numToTake;
                System.out.printf("Computer takes %d sticks. There are %d sticks left.%n", numToTake, sticks);
                if (sticks <= 0) {
                    System.out.println("You win!");
                } else {
                    System.out.println("How many sticks do you want to take? (1 or 2)");
                    numToTake = take.nextInt();
                    while (numToTake > 2 || numToTake < 1) {
                        System.out.println("Please pick 1 or 2:");
                        numToTake = take.nextInt();
                    }
                    sticks = sticks - numToTake;
                    System.out.printf("You took %d sticks. There are %d sticks left.%n", numToTake, sticks);
                    if (sticks <= 0) {
                        System.out.println("You lose!");
                    }

                }
            }
        }
    }
}
