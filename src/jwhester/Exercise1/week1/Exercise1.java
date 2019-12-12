package jwhester.Exercise1.week1;


import java.util.Scanner;
public class Exercise1 extends EasyMode {

    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        System.out.println(
                "██████╗  ██╗    ███████╗████████╗██╗ ██████╗██╗  ██╗███████╗\n" +
                "╚════██╗███║    ██╔════╝╚══██╔══╝██║██╔════╝██║ ██╔╝██╔════╝\n" +
                " █████╔╝╚██║    ███████╗   ██║   ██║██║     █████╔╝ ███████╗\n" +
                "██╔═══╝  ██║    ╚════██║   ██║   ██║██║     ██╔═██╗ ╚════██║\n" +
                "███████╗ ██║    ███████║   ██║   ██║╚██████╗██║  ██╗███████║\n" +
                "╚══════╝ ╚═╝    ╚══════╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝\n" +
                "                                                            ");
        System.out.println("Created By: J.W. Hester");
        System.out.println("Rules:\nYou start with 21 sticks, and two players take turns either taking one or two sticks. The player who takes the last stick loses.");
        System.out.println("Choose your mode:");
        System.out.println("1. Easy Mode");
        System.out.println("2. Hard Mode");
        System.out.println("3. VS Mode");
        System.out.println("Enter a number for your choice:");
        int choose = choice.nextInt();

        if (choose > 3 || choose < 1){
            System.out.println("Please enter 1, 2, or 3.");
            main(args);
        } else if (choose == 1){
            EasyRun();
        } else if (choose == 2){
            HardRun();
        } else if (choose == 3){
            VSrun();
        }




    }
}