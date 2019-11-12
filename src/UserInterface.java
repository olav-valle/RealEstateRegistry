import java.util.Scanner;

/**
 * The user interface of LotRegistry.
 */
public class UserInterface {
    private LotRegistry lotRegistry;
    private Scanner input;

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

            switch (this.getIntInput()) // get int input from user
            {
                case 0: finished = true;
                //exits application
            }
        }
     System.exit(0); // exit with 0
    }

    /**
     * Get integer input through System.in
     * @return
     */
    private int getIntInput() {
        int inputInt = input.nextInt();
        input.nextLine(); // solves problem of nextInt() leaving a line break behind

        return inputInt;
    }
    private double getDoubleInput()
    {
        double inputDouble = input.nextDouble();
        input.nextLine(); // solves problem of leaving a line break behind

        return inputDouble;
    }

}
