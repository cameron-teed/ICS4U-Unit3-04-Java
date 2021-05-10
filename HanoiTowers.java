/*
* This program uses recursion to play the tower of hanoi in java.
*
* @author Cameron Teed
* @version 1.0
* @since   2021-05-10
* Class HanoiTowers.
*/

import java.util.Scanner;

final class HanoiTowers {

  private HanoiTowers() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
   * Recursive function that plays the game out and prints moved.
   *
   * @param height
   * @param fromRod
   * @param toRod
   * @param auxRod
   */
  public static void towerOfHanoi(final int height, final String fromRod,
                               final String toRod, final String auxRod) {
    // When there is one ring, move it to rod C
    if (height == 1) {
      System.out.println("Move disk 1 from rod " + fromRod
                          + " to rod " + toRod);
    } else {
      // Takes the disk below and moves it using recursion
      towerOfHanoi(height - 1, fromRod, auxRod, toRod);
      // Prints out where the disk moved
      System.out.println("Move disk " + height + " from rod "
                          + fromRod + " to rod " + toRod);
      // Takes the disk below and moves it using recursion
      towerOfHanoi(height - 1, auxRod, toRod, fromRod);
    }
  }

  /**
   * main function to begin the game.
   *
   * @param args
   */
  public static void main(final String[] args) {
    try {
      // Asks user to input how many disks they want
      System.out.println("Enter how many disks you would like in your tower:");
      Scanner userInput = new Scanner(System.in);
      // Gets user input
      int height = userInput.nextInt();

      // Checks to see if user inputted correct input
      if (height >= 1) {
        // Calls function and prints done
        System.out.println();
        towerOfHanoi(height, "A", "C", "B");
        System.out.println("\nDone");
      } else {
        throw new Exception();
      }

    } catch (Exception e) {
      System.out.println("\nERROR: Invalid Input");
    }
  }
}
