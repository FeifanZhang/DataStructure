package ตฺถþีย;

import java.util.Scanner;

//Introduced in Chapter 2
//2.18 and 2.19
/** The game of Domineering. */
public class Domineering {

/** For reading from the console. */
public static final java.util.Scanner INPUT
 = new java.util.Scanner(System.in);

/** The player who plays their dominoes horizontally. */
public static final boolean HORIZONTAL = false;

/** The player who plays their dominoes vertically. */
public static final boolean VERTICAL = true;

/** Array of board squares, true if occupied. */
private boolean[][] squares;

/** The board is initially empty. */
public Domineering(int size) {
 squares = new boolean[size][size];
 // Java initializes all array elements to false
}

/**
* Return true if there is a legal move for the specified player.
*/
public boolean hasLegalMoveFor(boolean player) {
 int rowOffset = 0;
 int columnOffset = 0;
 if (player == HORIZONTAL) {
   columnOffset = 1;
 } else {
   rowOffset = 1;
 }
 for (int row = 0; row < (8 - rowOffset); row++) {
   for (int column = 0; column < (8 - columnOffset); column++) {
     if (!(squares[row][column]
           || squares[row + rowOffset][column + columnOffset])) {
       return true;
     }
   }
 }
 return false;
}

/** Play until someone wins. */
public void play() {
 boolean player = HORIZONTAL;
 while (true) {
   System.out.println("\n" + this);
   if (player == HORIZONTAL) {
     System.out.println("Horizontal to play");
   } else {
     System.out.println("Vertical to play");
   }
   if (!(hasLegalMoveFor(player))) {
     System.out.println("No legal moves -- you lose!");
     return;
   }
   for(;;)
   {
      System.out.print("Row: ");
      int row = INPUT.nextInt();
      System.out.print("Column: ");
      int column = INPUT.nextInt();
      if(check(row,column,player)==true)
      {
          playAt(row, column, player);
          break;
      }else
      {
    	  System.out.print("Illegal input,Please try again.\n");
      }
   }
   player = !player;
 }
}

public boolean check(int row,int column,boolean player)
{
	 if(row>=squares.length||column>=squares.length)
	 {
		 return false;
	 }
	 if (player == HORIZONTAL) 
	 {
	   if(squares[row][column + 1]== false&&squares[row][column]==false)
	   {
		   return true;
	   }
	   return false;
	 } else 
	 {
	   if(squares[row + 1][column]==false&&squares[row][column]==false)
	   {
		   return true;
	   }
	   return false;
	 }
}

/**
* Play a domino with its upper left corner at row, column.
*/
public void playAt(int row, int column, boolean player) {
 squares[row][column] = true;
 if (player == HORIZONTAL) {
   squares[row][column + 1] = true;
 } else {
   squares[row + 1][column] = true;
 }
}

public String toString() {
 //String result = "  0 1 2 3 4 5 6 7";
	String result="  ";
	for(int i=0;i<squares.length;i++)
	{
	    result += i+" ";	
	}
	
 for (int row = 0; row < squares.length; row++) {
   result += "\n" + row;
   for (int column = 0; column < squares.length; column++) {
     if (squares[row][column]) {
       result += " #";
     } else {
       result += " .";
     }
   }
 }
 return result;
}

/** Create and play the game. */
public static void main(String[] args) {
 System.out.println("Welcome to Domineering.");
 System.out.println("Input the size of the Square.");
 int size=INPUT.nextInt();
 Domineering game = new Domineering(size);
 game.play();
}

}
