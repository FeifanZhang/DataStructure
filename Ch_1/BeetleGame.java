package 第一章;

import 第三章.Die;

//Introduced in Chapter 1
/** The game of Beetle for two players. */
public class BeetleGame {

/** For reading from the console. */
public static final java.util.Scanner INPUT
 = new java.util.Scanner(System.in);

/** Player 1's Beetle. */
private Beetle bug1;

/** Player 2's Beetle. */
private Beetle bug2;


private Beetle bug3;

/** A die. */
private Die die;

/** Create the Die and Beetles. */
public BeetleGame() {
 bug1 = new Beetle();
 bug2 = new Beetle();
 bug3 = new Beetle();
 die = new Die();
}

/** Play until someone wins. */
public void play() {
 int player = 1;
 Beetle bug = bug1;
 while (!(bug.isComplete())) 
 {
   if (!(takeTurn(player%3+1, bug)))
   {
	 player = player+1;
     if (player%3+1 == 1) 
     {
       
       bug = bug1;
     } if(player%3+1 == 2) 
     {
       
       bug = bug2;
     }else
     {
    	 
         bug = bug3;
     }
   }
 }
 System.out.println("\nPlayer " + player%3+1 + " wins!");
 System.out.println(bug);
}

/**
* Take a turn for the current player.  Return true if the player
* earned a bonus turn.
*/
public boolean takeTurn(int player, Beetle bug) {
 System.out.println("\nPlayer " + player%3+1 + ", your beetle:");
 System.out.println(bug);
 System.out.print("Hit return to roll: ");
 INPUT.nextLine();
 die.roll();
 System.out.print("You rolled a " + die.getTopFace());
 switch (die.getTopFace()) {
   case 1:
     System.out.println(" (body)");
     return bug.addBody();
   case 2:
     System.out.println(" (head)");
     return bug.addHead();
   case 3:
     System.out.println(" (leg)");
     return bug.addLeg();
   case 4:
     System.out.println(" (eye)");
     return bug.addEye();
   case 5:
     System.out.println(" (feeler)");
     return bug.addFeeler();
   default:
     System.out.println(" (tail)");
     return bug.addTail();
 }
}

/** Create and play the game. */
public static void main(String[] args) {
 System.out.println("Welcome to Beetle.");
 BeetleGame game = new BeetleGame();
 game.play();
}

}
