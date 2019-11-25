import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.Scanner;

/**
 * The user interface of LotRegistry.
 */
public class UserInterface {
    private LotRegistry lotRegistry;
    private Scanner input;

    //Menu item constants
    final int LIST = 1;
    final int ADD = 2;
    final int SEARCH = 3;
    final int AREA = 4;
    final int QUIT = 5;
    final int INVALID = 0;
    //
    /**
     * Constructor.
     */
    UserInterface()
    {
        lotRegistry = new LotRegistry();
        input = new Scanner(System.in);
    }

    public void initUI() {

        boolean finished = false; // keep menu switch going

        while (!finished)
        {
            mainMenu();
            switch (this.getIntInput()) // get int input from user
            {
                case LIST: ;
                case ADD: ;
                case SEARCH: ;
                case AREA: ;
                case QUIT: finished = true;
                    //exits menu
                case INVALID: ;
            }
        }
     System.exit(0); // exit with 0
    }

    private void mainMenu() {
        System.out.println("Select function by entering a number. ");
        System.out.println("-------------------------------------");
        System.out.println("1. List properties in registry.");
        System.out.println("2. Add property to registry.");
        System.out.println("3. Search for properties.");
        System.out.println("4. Show average size of properties.");
        System.out.println("-------------------------------------");
        System.out.println("Confirm selection with return.");
    }

    /**
     * Get integer input through System.in
     * @return integer number input by user.
     */
    private int getIntInput() {
        System.out.println("Enter a whole number:");
        System.out.print(">");
        int inputInt = 0; //returns 0 as default, in case of user error
        if (input.hasNextInt()) {
            inputInt = input.nextInt();
            input.nextLine(); // solves problem of nextInt() leaving a line break behind
        } else {
            System.out.println("Please enter a whole number between " + LIST + " and " + QUIT);
        }
        return inputInt;
    }
        /**
         * Get double type input through System.in.
         * @return double type number input by user.
         */
    private double getDoubleInput()
    {
        System.out.println("Enter a decimal number, using period as separator:");
        System.out.print(">");
        double inputDouble = input.nextDouble();
        input.nextLine(); // solves problem of leaving a line break behind

        return inputDouble;
    }

    private void printDetailsIterator(Iterator it)
    {
        it.forEachRemaining(lot -> printLotDetails((LandLot) lot));
        //cast to LandLot type is safe, since LotRegistry.valuesIterator returns Iterator<LandLot>
        //TODO Or is it?
    }

    private void printLotDetails(LandLot lot) {
        if (lot != null){
            System.out.println("-------------------------------------");
            System.out.println("Property ID: " + lot.getLotID());
            System.out.println("");
        }

    }

}
