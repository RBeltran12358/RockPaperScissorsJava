import java.util.Scanner;

public class Main {

    private static boolean again;
    private int g_played = 0;


    public static void main(String[] args) {
        again = true;
        //set up by making a game and populating its upto and players.
        Game game = new Game(promptUpToPoints(), null, null  ); // fix generate Players so I dont have to make them null
        game.generatePlayers();

        while(again){
            game.playGame();
            game.endSummary();
            again = playAgain();
            // Have to reset the points for the players
            game.getPlayer1().setPoints(0);
            game.getPlayer2().setPoints(0);
        }
        System.out.println("Thank you for playing, hope you enjoyed it!");


        // set up game 1.set up players 2.how many points up to 3. simple or with the five options
        // play game
        // ask if they want to see their stats
        // ask if they want to play again



    }

    public static boolean playAgain(){
        System.out.println("Would you like to play another game? y/n");
        Scanner obj = new Scanner(System.in);
        String con = obj.nextLine();
        return con.equals("y")||con.equals("yes")||con.equals("Yes");
    }

    public static int promptUpToPoints(){
        System.out.println("Up to how many points would you like to play to? ");
        Scanner obj = new Scanner(System.in);
        return Integer.parseInt(obj.nextLine());
    }





}
