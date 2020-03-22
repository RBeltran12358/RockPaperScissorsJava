import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private int wins;
    private int losses;

    public Player(){
        this.name = "Guest";
        this.points = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public Player(String name){
        this.name = name;
        this.points = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return name;
    }

    public int getLosses() {
        return losses;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    //    public void generatePlayers(){
//        String a = askPlayersName();
//        String b = askPlayersName();
//
//        Game.setPlayer1(new Player(a));
//        Game.setPlayer2(new Player(b));
//    }

//    public String askPlayersName(){
//        if(Game.getPlayer1() == null){
//            System.out.println("What is the name of the first player? ");
//        }
//        else{
//            System.out.println("What is the name of the next player? ");
//        }
//        Scanner myObj = new Scanner(System.in);
//        String pname = myObj.nextLine();
//
//        return pname;
//    }




}
