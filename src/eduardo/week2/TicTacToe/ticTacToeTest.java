package eduardo.week2.TicTacToe;
import java.util.Scanner;

public class ticTacToeTest {
    public static void main(String[] args){
        ticTacToe games = new ticTacToe();
        boolean response;
        Scanner sc = new Scanner(System.in);

        do{
            games.game();

            System.out.println("Do we have any more players to participate?");
            String userResponse = sc.nextLine();
            userResponse.trim();

            if(userResponse.equalsIgnoreCase("y") || userResponse.equalsIgnoreCase("yes")){
                response = true;
            }else {
                response = false;
                System.out.println("Thank you for using the Tic Tac Toe Game program...Have a nice day..");
            }
        }while (response);


    }

}
