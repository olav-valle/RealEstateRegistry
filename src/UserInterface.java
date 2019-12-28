import java.util.Iterator;
/**
 * The user interface of LotRegistry.
 */
public class UserInterface {
    private LotRegistry lotRegistry;
    private Input input;

    //Menu item constants
    private final int LIST = 1;
    private final int ADD = 2;
    private final int SEARCH = 3;
    private final int AREA = 4;
    private final int REMOVE = 5;
    private final int QUIT = 9;

    // constants reserved for testing and error handling
    private final int TEST = 11;
    private final int INVALID = 0;

    //
    /**
     * Constructor.
     */
    public UserInterface()
    {
        lotRegistry = new LotRegistry();
        input = new Input();
    }//UserInterface

    /**
     * The user interface. Displays a menu of choices of the applications functionality,
     * and accepts user input to select a function.
     */
    public void initUI() {

        while (true){ //endless loop
            mainMenu(); //prints the main menu list
            switch (intInput()){ // get int input from user
                case LIST:      //lists all lots in registry
                    listLots();
                    break;
                case ADD:       //adds a lot to the registry
                    createNewLot();
                    break;
                case REMOVE:    //remove a lot from registry
                    removeLot();
                    break;
                case SEARCH:    //searches for lots in the registry
                    searchRegistry();
                    break;
                case AREA:      //shows average size of a lot, across all lots in registry
                    System.out.println("-------------------------------------");
                    System.out.println("The average area of a lot in the registry is " + lotRegistry.getAverageArea()
                            + " square meters");
                    break;
                case INVALID:   //invalid input uses default
                default:        //informs user of menu input error
                    System.out.println("Please enter a whole number between " + LIST + " and " + QUIT);
                    break;
                case TEST:      //adds lots to registry for testing purposes
                    addLots();
                    break;
                case QUIT:      //closes application
                    System.out.println("Goodbye.");
                    System.exit(0); // exit with 0
                    break;
            }//switch
        }//while
    }//initUI

    /**
     * Prints the main menu of the UI.
     */
    private void mainMenu() {
        System.out.println("Select function by entering a number. ");
        System.out.println("-------------------------------------");
        System.out.println("1. List properties in registry.");
        System.out.println("2. Add property to registry.");
        System.out.println("3. Search for properties.");
        System.out.println("4. Show average size of properties.");
        System.out.println("5. Remove lot by ID.");
        System.out.println("9. Quit.");
        System.out.println("-------------------------------------");
        System.out.println("Confirm selection with return.");
    }//mainMenu

    /**
     *
     */
    private void listLots()
    {
        if (lotRegistry.getRegistrySize() != 0) {
            System.out.println("-------------------------------------");
            System.out.println("Listing all " + lotRegistry.getRegistrySize() + " lots in registry.");
            printDetailsIterator(lotRegistry.getValuesIterator());
        }
        else {
            System.out.println("No lots found in registry.");
        }
    }
    /**
     * Guides the user through the creation of a new land lot, and adds it to the registry.
     */
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
//TODO check inputs
        LandLot newLot = new LandLot(muniName, muniNumber, lotNumber, sectionNumber, ownerName, area, lotName);
        lotRegistry.addLot(newLot);

    }//createNewLot

    /**
     * Removes a lot from the registry, using a user input lot ID of format "1234-56/789
     */
    private void removeLot()
    {
        System.out.println("-------------------------------------");
        System.out.println("Enter the exact Lot ID of the lot to remove: ");
        System.out.println("Format of ID is 1234-56/789");
        System.out.println("-------------------------------------");
        String lotID = stringInput();
        LandLot lot = lotRegistry.getLotByID(lotID);
        if (lot != null){
            printLotDetails(lot);
            System.out.println("-------------------------------------");
            System.out.println("This lot will be deleted:");
            System.out.println("Confirm: Y/N ");
            if(stringInput().equalsIgnoreCase("y")){
                lotRegistry.removeLot(lotID);
                System.out.println("-------------------------------------");
                System.out.println("            Lot removed.");
                System.out.println("-------------------------------------");
            }//if
            else{
                System.out.println("-------------------------------------");
                System.out.println("            Removal aborted.");
                System.out.println("-------------------------------------");
            }//else
        }//if (!= null)
        else{
            System.out.println("-------------------------------------");
            System.out.println("Lot not found.");
            System.out.println("Please confirm Lot ID, and try again.");
            System.out.println("The ID you entered was: " + lotID);
            System.out.println("-------------------------------------");
        }//else
    }//removeLot
    /**
     * Accepts user inputs of municipality number, lot number and lot section,
     * and displays lots in the registry that match.
     */
    private void searchRegistry()
    {
        System.out.println("-------------------------------------");
        System.out.println("Enter municipality number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        int muniNumber = intInput();
        System.out.println("Enter land lot number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        int lotNumber = intInput();
        System.out.println("Enter lot section number: ");
        System.out.println("Enter 0 if unknown or irrelevant to search.");
        System.out.println("-------------------------------------");
        int sectionNumber = intInput();
        printDetailsIterator(lotRegistry.search(muniNumber, lotNumber, sectionNumber));

    }//searchRegistry

    /**
     * Calls printLotDetails on each object in an iterator.
     * @param it iterator of lots to print details
     */
    private void printDetailsIterator(Iterator it)
    {
        it.forEachRemaining(lot -> printLotDetails((LandLot) lot));
        //cast to LandLot type is safe, since LotRegistry.valuesIterator returns Iterator<LandLot>
        //TODO Or is it?
    }

    /**
     * Prints relevant details about a lot.
     * Details are printed in the following format:
     * -------------------------------------
     * Lot ID:              1234-56/78
     * Lot is locate in:    Municipality
     * Owner of property:   Owner Name
     * Name of lot:         Lot Name
     * Size of lot:         1234.56 square meters
     *
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
        System.out.println("Super secret developer option #11: Adding lots of lots...");
        lotRegistry.addLot(new LandLot("Gloppen",1445,77,631,"Jens Olsen", 1017.6, ""));
        lotRegistry.addLot(new LandLot("Gloppen",1445,77,131,"Nicolay Madsen", 661.3, "Syningom"));
        lotRegistry.addLot(new LandLot("Gloppen",1445,75,19,"Evilyn Jensen",650.6,"Fugletun"));
        lotRegistry.addLot(new LandLot("Gloppen",1445,74,188,"Karl Ove Bråten",1457.2, ""));
        lotRegistry.addLot(new LandLot("Gloppen",1445,69,47, "Elsa Indregård",1339.4,"Høiberg"));

    }//addLots
}//UserInterface
