package edu.nyu.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped{

    
    private String orientation = "south";
    private int orientationNumber = 0;
    private int street = 1;
    private int avenue = 1;
    private int gas = 20;
    private static int mopedAmount = 0;
    private int index = 0;

    private final int minStreet = 1;
    private final int minAvenue = 1;
    private final int maxStreet = 200;
    private final int maxAvenue = 10;
    private final String help = "\"go left\": Makes the moped go left one block. \n\"go right\": Makes the moped go right one block. \n\"straight on\": Makes the moped go forwards one block. \n\"back up\": Makes the moped go backwards one block. \n\"how we doin'?\": Checks gas level. \n\"fill it up\": Refills the gas tank. \n\"park\": Parks the moped, exiting the program. \n\"go to Xi'an Famous Foods\": Instructs the moped to go homing to Xi'an Famous Foods. \n\"help\": Repeats this message. \n";

    private ArrayList<String[]> adSpots = new ArrayList<String[]>();


    public Moped(int street, int avenue) {
        this.street = street;
        this.avenue = avenue;
        index = mopedAmount;
        mopedAmount++;

    }

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;

    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation;   
    }

    /**
     * Sets the street of the moped to a particular street.
     * Should not be used in most cases due to black-box approach, but left as an option.
     * @param street An int representing which street the moped should be on.
     */
    public void setStreet(int street){
        this.street = street;
    }

    /**
     * Returns the current street of the moped, as a cardinal number.
     * E.g. 1, 2, 3, 4...
     * @return The current street of the moped, as an int.
     */
    public int getStreet(){
        return street;
    }

    /**
     * Sets the avenue of the moped to a particular avenue.
     * Should not be used in most cases due to black-box approach, but left as an option.
     * @param avenue An int representing which avenuethe moped should be on.
     */
    public void setAvenue(int avenue){
        this.avenue = avenue;
    }

    /**
     * Returns the current avenue of the moped, as a cardinal number.
     * E.g. 1, 2, 3, 4...
     * @return The current avenue of the moped, as an int.
     */
    public int getAvenue(){
        return avenue;
    }
    
    /** Converts cardinal numbers to ordinal numbers.
     * @param cardinal The cardinal number to be converted into an ordinal number, as an int.
     * @return The ordinal number corresponding to the cardinal number, as a String.
     */
    private String cardinalToOrdinal(int cardinal){
        String ordinalOutput = "";
        if (cardinal%100 == 11 || cardinal%100 == 12 || cardinal%100 == 13){
            ordinalOutput += (cardinal + "th");
        }
        else if (cardinal%10 == 1){
            ordinalOutput += (cardinal + "st");
        }
        else if (cardinal%10 == 2){
            ordinalOutput += (cardinal + "nd");
        }
        else if (cardinal%10 == 3){
            ordinalOutput += (cardinal + "rd");
        }
        else {
            ordinalOutput += (cardinal + "th");
        }
        return ordinalOutput;
    }
    
    /** Capitalises the first letter of the string inputted.
     * @param input The string to be capitalised.
     * @return A string with the first letter capitalised and all other characters ignored.
     */
    private String capitaliseFirstLetter(String input){
        String firstLetter = input.substring(0,1).toUpperCase();
        String restOfInput = input.substring(1);
        String output = firstLetter+restOfInput;
        return output;
    }
    
    /** Sets up ads — method here should make adding further ads easier if more sponsors obtained :)
     * 
     */
    public void setupAds(){
        String[] AMNH = new String[]{"79","8","The American Museum of Natural History is one of the world's preeminent scientific and cultural institutions."};
        adSpots.add(AMNH);
        String[] MSK = new String[]{"74","1","The people of Memorial Sloan Kettering Cancer Center (MSK) are united by a singular mission: ending cancer for life."};
        adSpots.add(MSK);
        String[] TCC = new String[]{"56","3","Here at Tina's Cuban Cuisine, we believe that great cooking starts with a simple philosophy: slow cooking served fast and fresh."};
        adSpots.add(TCC);
        String[] TheStrand = new String[]{"12","4","Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?"};
        adSpots.add(TheStrand);

        String[] XFF = new String[]{"15","8","We have reached Xi'an Famous Foods.  Enjoy your noodles."};
        adSpots.add(XFF);
    }
    
    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        String streetOrdinal = cardinalToOrdinal(street);
        String avenueOrdinal = cardinalToOrdinal(avenue);
        String capitalisedOrientation = capitaliseFirstLetter(orientation);
        String fullPrint = name() + " is now at "+streetOrdinal+ " St. and "+avenueOrdinal+" Ave, facing "+capitalisedOrientation+".";
        for (int i = 0; i<adSpots.size();i++){
            if (street == Integer.parseInt(adSpots.get(i)[0]) && avenue == Integer.parseInt(adSpots.get(i)[1])){
                fullPrint += "  " + adSpots.get(i)[2];
            }
        }
        System.out.println(fullPrint);

    }

    /** Checks whether the moped is currently on the northern boundary of the grid.
     * @return a boolean value which is true if it is on the boundary and false if not.
     */
    public boolean checkNorthBoundary(){
        if (street==maxStreet){
            return true;
        }
        else{
            return false;
        }
    }
    /** Checks whether the moped is currently on the western boundary of the grid.
     * @return a boolean value which is true if it is on the boundary and false if not.
     */
    public boolean checkWestBoundary(){
        if (avenue==maxAvenue){
            return true;
        }
        else{
            return false;
        }
    }
    /** Checks whether the moped is currently on the southern boundary of the grid.
     * @return a boolean value which is true if it is on the boundary and false if not.
     */
    public boolean checkSouthBoundary(){
        if (street==minStreet){
            return true;
        }
        else{
            return false;
        }
    }
    /** Checks whether the moped is currently on the eastern boundary of the grid.
     * @return a boolean value which is true if it is on the boundary and false if not.
     */
    public boolean checkEastBoundary(){
        if (avenue==minAvenue){
            return true;
        }
        else{
            return false;
        }
    }
   
    /** Updates the String for orientation. Call whenever orientationNumber is changed!!
     * 
     */
    private void orientationNumberToOrientation(){
        switch(orientationNumber%4){
            case 0:
                this.orientation = "south";
                break;
            case 1:
                this.orientation = "west";
                break;
            case 2:
                this.orientation = "north";
                break;
            case 3:
                this.orientation = "east";
                break;
        }
    }
    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        if (getGasLevel()!=0){
            orientationNumber +=3;
            orientationNumberToOrientation();
            goStraight();
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        if (getGasLevel()!=0){
            orientationNumber +=1;
            orientationNumberToOrientation();
            goStraight();
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
       if(getGasLevel()!=0){
        switch(orientation){
            case "north":
                if(!checkNorthBoundary()){
                    street++;
                }
                break;
            case "south":
                if(!checkSouthBoundary()){
                    street--;
                }
                break;
            case "east":
                if(!checkEastBoundary()){
                    avenue--;
                }
                break;
            case "west":
                if(!checkWestBoundary()){
                    avenue++;
                }
                break;
        }
        gas--;
       }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        if (getGasLevel()!=0){
            orientationNumber +=2;
            orientationNumberToOrientation();
            goStraight();
            orientationNumber +=2;
            orientationNumberToOrientation();
        }
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return gas*5;
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        int gasLevel = getGasLevel();
        if (gasLevel==0){
            System.out.println("We have run out of gas. Bye bye!");
            System.exit(0);
        }
        else {
            System.out.println("The gas tank is currently "+gasLevel+"% full.");
        }
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.gas = 20;
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We have parked");
        System.exit(0);
    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        while (street!=15){
            if (orientationNumber%4 == 1){
                goRight();
                orientationNumberToOrientation();
            }
            else if (orientationNumber%4 == 3){
                goLeft();
                orientationNumberToOrientation();
            }
            else if (orientationNumber%4 == 0){
                goBackwards();
                orientationNumberToOrientation();
            }
            else {
                goStraight();
                orientationNumberToOrientation();
            }
            if(getGasLevel()==0){
                fillGas();
            }
            printLocation();
        }
        goRight();
        while (avenue!=8){
            if(avenue>8){
                goBackwards();
            }
            else{
                goStraight();
            }
            printLocation();
        }
        printLocation();
    }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        return help;     
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.street = location[0];
        this.avenue = location[1];
    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        int[] location = {street, avenue};
        return location;
    }
    /**
     * Exits program in case of moped crash.
     */
    public void crash(){
        System.out.println("Your  moped has crashed and is totally unusable...");
        System.exit(0);
    }

    /** Moves randomly (for the Drunk drivers!)
     * 
     */
    public void randomMove(){
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        switch(randomNumber%4){
            case 0:
                goLeft();
                break;
            case 1:
                goRight();
                break;
            case 2:
                goBackwards();
                break;
            case 3:
                goStraight();
                break;
        }
    }

    public String name(){
        String output = "";
        if (index==0){
            output += "User Moped";
        }
        else {
            output += "Drunk Moped " + index;
        }
        return output;
    }

}
