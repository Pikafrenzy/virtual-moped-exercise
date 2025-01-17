package edu.nyu.cs;

import java.util.Scanner;

public class TestDrive {

  /**
   * The main function is automatically called first in a Java program.
   * It should instantiate a Moped and contain the main logic of the program, following the instructions.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    Moped m = new Moped();
    m.setupAds();
    Moped drunk1 = new Moped();
    Moped drunk2 = new Moped();

    // solution
    System.out.println("Thanks for jumping on the moped.  We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.  May I say your teeth look very clean.");
    System.out.println("What would you like to do?  At any time, say \"help\" for assistance.");

    boolean keepGoing = true;
    String response = "";
    while (!keepGoing) {
      response = scn.nextLine();
        switch (response) {
            case "go left":
                m.goLeft();
                m.printLocation();
                break;
            case "go right":
                m.goRight();
                m.printLocation();
                break;
            case "straight on":
                m.goStraight();
                m.printLocation();
                break;
            case "back up":
                m.goBackwards();
                m.printLocation();
                break;
            case "fill it up":
                m.fillGas();
                m.printGasLevel();
                break;
            case "how we doin'?":
                m.printGasLevel();
                break;
            case "go to Xi'an Famous Foods":
                m.goToXianFamousFoods();
                break;
            case "park":
                m.park();
                keepGoing = false;
                break;
            case "help":
                System.out.print(m.getHelp());
                break;
            default:
                System.out.println("I'm sorry, I don't understand that command. Type 'help' for a list of commands");
        }

        drunk1.randomMove();
        drunk2.randomMove();
        drunk1.printLocation();
        drunk2.printLocation();
        if (drunk1.getGasLevel()<= 10){
            drunk1.fillGas();
            drunk2.fillGas();
        }

        if (sameLocation(m,drunk1)||sameLocation(m, drunk2)){
            m.crash();
            keepGoing = false;
            continue;
        }
        if (m.getGasLevel()==0){
            m.printGasLevel();
            keepGoing = false;
            continue;
        }
    }
  }
  public static boolean sameLocation(Moped m, Moped drunk){
    for (int i = 0; i< m.getLocation().length;i++){
        if (m.getLocation()[i] != drunk.getLocation()[i]){
            return false;
        }
    }
    return true;
  }

}
