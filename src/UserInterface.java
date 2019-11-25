import java.util.Iterator;
/**
 * The user interface of LotRegistry.
 */
public class UserInterface {
    private LotRegistry lotRegistry;
    private Input input;

    //Menu item constants
    final int LIST = 1;
    final int ADD = 2;
    final int SEARCH = 3;
    final int AREA = 4;
    final int QUIT = 5;

    // constants reserved for testing and error handling
    final int TEST = 9;
    final int INVALID = 0;

    //
    /**
     * Constructor.
     */
    UserInterface()
    {
        lotRegistry = new LotRegistry();
        input = new Input();
    }

    public void initUI() {

        boolean finished = false; // keep menu switch going

        while (!finished){
            mainMenu(); //prints the main menu list
            switch (intInput()){ // get int input from user
                case LIST:      //lists all lots in registry
                    System.out.println("-------------------------------------");
                    System.out.println("Listing all lots in registry.");
                    printDetailsIterator(lotRegistry.valuesIterator());
                    break;
                case ADD:       //adds a lot to the registry
                    createNewLot();
                    break;
                case SEARCH:    //searches for lots in the registry
                    searchRegistry();
                    break;
                case AREA:      //shows average size of a lot, across all lots in registry
                    System.out.println("-------------------------------------");
                    System.out.println("The average area of a lot in the registry is " + lotRegistry.getAverageArea()
                            + " square meters");
                    break;
                case QUIT:      //closes application
                    System.out.println("Goodbye.");
                    finished = true;
                    break;
                case TEST:      //adds lots to registry for testing purposes
                    addLots();
                case INVALID:   //invalid input uses default
                default:        //informs user of menu input error
                    System.out.println("Please enter a whole number between " + LIST + " and " + QUIT);
                    break;
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
        System.out.println("5. Quit.");
        System.out.println("-------------------------------------");
        System.out.println("Confirm selection with return.");
    }

    private void createNewLot() {
        System.out.println("Enter name of municipality: ");
        String muniName = stringInput();
        System.out.println("Enter municipality number: ");
        int muniNumber = intInput();
        System.out.println("Enter land lot number: ");
        int lotNumber = intInput();
        System.out.println("Enter lot section number: ");
        int sectionNumber = intInput();
        System.out.println("Enter name of lot owner: ");
        String ownerName = stringInput();
        System.out.println("Enter size of lot area" );
        double area = doubleInput();
        System.out.println("Enter lot name: ");
        System.out.println("[Leave blank if lot has no name]");
        String lotName = input.getString();

        LandLot newLot = new LandLot(muniName, muniNumber, lotNumber, sectionNumber, ownerName, area, lotName);
        lotRegistry.addLot(newLot);

    }

    private void searchRegistry()
    {
        System.out.println("Enter municipality number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        int muniNumber = intInput();
        System.out.println("Enter land lot number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        int lotNumber = intInput();
        System.out.println("Enter lot section number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        int sectionNumber = intInput();
        printDetailsIterator(lotRegistry.search(muniNumber, lotNumber, sectionNumber));

    }

    /**
     * Calls printLotDetails on each object in an iterator.
     * @param it
     */
    private void printDetailsIterator(Iterator it)
    {
        it.forEachRemaining(lot -> printLotDetails((LandLot) lot));
        //cast to LandLot type is safe, since LotRegistry.valuesIterator returns Iterator<LandLot>
        //TODO Or is it?
    }

    /**
     * Prints relevant details about a lot.
     * @param lot the lot whose details are to be printed.
     */
    private void printLotDetails(LandLot lot) {
        if (lot != null){
            System.out.println("-------------------------------------");
            System.out.println("Lot ID:             " + lot.getLotID());
            System.out.println("Lot is located in:  " + lot.getMuniName());
            System.out.println("Owner of property:  " + lot.getOwnerName());
            System.out.println("Name of lot:        " + lot.getLotName());
            System.out.println("Size of lot:        " + lot.getArea() + " square meters.");

        }//if

    }//printLotDetails

    /**
     * Gets int input from user.
     * @return returns user input as integer.
     */
    private int intInput()
    {
        System.out.println("Enter a whole number:");
        System.out.print(">");
        return input.getIntInput();
    }//intInput

    /**
     * Gets double input from user.
     * @return returns user input as Double.
     */
    private double doubleInput()
    {
        System.out.println("Enter a decimal number, using period as separator:");
        System.out.print(">");
        return input.getDoubleInput();
    }//doubleInput

    /**
     * Gets String input from user.
     * @return returns user input as String.
     */
    private String stringInput()
    {
        System.out.println("Enter a string of text: ");
        System.out.print(">");
        return input.getString();
    }//stringInput

    /**
     * Adds a collection of lots  to the registry for testing and demonstration purposes.
     */
    private void addLots()
    {
        System.out.println("Super secret developer menu... Adding lots.");
        lotRegistry.addLot(new LandLot("Gloppen",1445,77,631,"Jens Olsen", 1017.6, ""));
        lotRegistry.addLot(new LandLot("Gloppen",1445,77,131,"Nicolay Madsen", 661.3, "Syningom"));
        lotRegistry.addLot(new LandLot("Gloppen",1445,75,19,"Evilyn Jensen",650.6,"Fugletun"));
        lotRegistry.addLot(new LandLot("Gloppen",1445,74,188,"Karl Ove Bråten",1457.2, ""));
        lotRegistry.addLot(new LandLot("Gloppen",1445,69,47, "Elsa Indregård",1339.4,"Høiberg"));

    }//addLots
}
