package eduardo.week2.TicTacToe;

public class Player {
    private String name;
    private int gamesWon;

    public Player(String name){
        this.name = name;
        gamesWon = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getGamesWon(){
        return gamesWon;
    }

    public void playerWon(){
        gamesWon++;
    }


}
