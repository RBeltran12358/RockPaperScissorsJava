import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Turn> turn_list; // a game ought to have multiple turns
    private int up_to; // the number of points a game goes up to
    private Player player1 = null;
    private Player player2 = null;
    private int numTurns;

    public Game(int up_to, Player one, Player two){
        this.up_to = up_to;
        player1 = one;
        player2 = two;
        this.numTurns = 0;
    }


    public void playGame() {
        while(player1.getPoints()!= up_to && player2.getPoints()!=up_to){
            // ask first player what their answer will be..Rock..Paper..
            // ask second player what their answer will be  Rock..etc
            numTurns++;
            String f_p = promptAction(player1);
            String s_p = promptAction(player2);
            int result = compareAnswers(player1, player2, f_p, s_p);
            if(result<0){
                player1.setPoints(player1.getPoints()+1);
            }
            if(result>0){
                player2.setPoints(player2.getPoints()+1);
            }
        }

        if(player1.getPoints()==up_to){
            System.out.println(player1.getName()+ " is the WINNER of this game!!!!!\n");
            player1.setWins(player1.getWins()+1);
            player2.setLosses(player2.getLosses()+1);
        }else{
            System.out.println(player2.getName()+ " is the WINNER of this game!!!!!\n");
            player2.setWins(player2.getWins()+1);
            player1.setLosses(player1.getLosses()+1);
        }
    }

    public void endSummary(){
        System.out.println("Would you like to see a summary of all the games? y/n");
        Scanner obj = new Scanner(System.in);
        String answer = obj.nextLine();
        if(answer.equals("y")){
            System.out.println(this);
        }
    }

    public void setUp(){
        generatePlayers();
    }

    public void generatePlayers(){
        String a = askPlayersName();
        setPlayer1(new Player(a));
        String b = askPlayersName();
        setPlayer2(new Player(b));
    }

    public String askPlayersName(){
        if(player1 == null){
            System.out.println("What is the name of the first player? ");
        }
        else{
            System.out.println("What is the name of the next player? ");
        }
        Scanner myObj = new Scanner(System.in);
        String pname = myObj.nextLine();

        return pname;
    }

    public int getNumTurns() {
        return numTurns;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setNumTurns(int numTurns) {
        this.numTurns = numTurns;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setUp_to(int up_to) {
        this.up_to = up_to;
    }

    public void setTurn_list(ArrayList<Turn> turn_list) {
        this.turn_list = turn_list;
    }

    public int getUp_to() {
        return up_to;
    }

    public ArrayList<Turn> getTurn_list() {
        return turn_list;
    }



    public String promptAction(Player p){
        System.out.println( p.getName() + ", what will your action be?\nEnter 'r' for Rock, 'p' for Paper and 's' for Scissors");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();
        while(!isValid(response)){
            System.out.println("Incorrect Input\nEnter 'r' for Rock, 'p' for Paper and 's' for Scissors");
            Scanner Obj = new Scanner(System.in);
            response = Obj.nextLine();
        }
       return response;
    }

    public boolean isValid(String response){
        return response.equals("r") ||response.equals("p") ||response.equals("s");
    }

    public int compareAnswers(Player one, Player two, String user1, String user2){
        if(user1.equals("r")){
            if(user2.equals("r")){
                System.out.println("It seems you tied this round!\n");
                return 0;
            }else if(user2.equals("p")){
                System.out.println(two.getName() + " wins this time!\n");
                return 1;
            }else{
                System.out.println(one.getName() + " has come on top this time around!\n");
                return -1;
            }
        }
        else if (user1.equals("p")){
            if(user2.equals("p")){
                System.out.println("It seems you tied this round!\n");
                return 0;
            }else if(user2.equals("s")){
                System.out.println(two.getName() + " has come on top this time around!\n");
                return 1;
            }else{
                System.out.println(one.getName() +  " wins this time!\n");
                return -1;
            }
        }
        else{
            if(user2.equals("s")){
                System.out.println("It seems you tied this round! Stop copying each other\n");
                return 0;
            }else if(user2.equals("r")){
                System.out.println(two.getName() + " has come on top this time around!\n");
                return 1;
            }else{
                System.out.println(one.getName() +  " is the winner of the round\n");
                return -1;
            }
        }
    }

    @Override
    public String toString() {
//        if(player1.getPoints() > player2.getPoints()){
        return "Game:" + "\nPlayer " + player1.getName() + " Stats: " + "\nAll-Time Wins: " + player1.getWins() + "\nAll-Time Losses: " + player1.getLosses() +
                "\nPoints this Game: " + player1.getPoints() + "." + "\n\n" + "Player " + player2.getName() + " Stats: " + "\nAll-Time Wins: " + player2.getWins() + "\nAll-Time Losses: " + player2.getLosses() +
                "\nPoints this Game: " + player2.getPoints() + '.';
    }
}
