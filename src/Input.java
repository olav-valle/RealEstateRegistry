import java.util.Scanner;

/**
 * A class that handles user input.
 * @author Olav Valle
 * @version 2019/11/25
 */
public class Input {

    private Scanner input;

    public Input(){
        input = new Scanner(System.in);
    }

    /**
     * Get integer input through System.in
     * @return integer number input by user, or 0 if user input was not of type int.
     */
    public int getIntInput()
    {
        int inputInt = 0; //returns 0 as default, in case of user error
        if (input.hasNextLine()) {
            String tempString  = input.nextLine();
                    if(tempString.isBlank()){
                        tempString = "0";
                    }
//TODO read more about Integer.parseInt(). How does it handle parsing strings that are alpha?
            // judging by the NumberFormatException, I'd say the answer is "badly"...
            inputInt = Integer.parseInt(tempString);
        }
        //input.nextLine(); // solves problem of nextInt() leaving a line break behind
        System.out.println(inputInt);
        return inputInt;
    }
    /**
     * Get double type input through System.in.
     * @return double type number input by user, or 0 if user input was not of type double.
     */
    public double getDoubleInput()
    {
        double inputDouble = 0;
        if (input.hasNextLine()) {
            String tempDouble = input.nextLine();
                if(tempDouble.isBlank()){
                    tempDouble = "0";
                }
            inputDouble = Double.parseDouble(tempDouble);
        }
        //input.nextLine(); // solves problem of leaving a line break behind
        return inputDouble;
    }

    /**
     * Returns a user input string.
     * @return user input as String, or empty string if user input was not of type String.
     */
    public String getString() {
        String inputString = "";
        if(input.hasNext())
        {
            inputString = input.nextLine();
        }
        return inputString;
    }
}
