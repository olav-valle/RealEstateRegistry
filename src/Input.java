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

                try{
                    inputInt = Integer.parseInt(tempString.trim());
                }
                catch (NumberFormatException nonNumericInput){
                    inputInt = 0;
                }

            //TODO read more about Integer.parseInt(). How does it handle parsing strings that are alpha?
            // judging by the NumberFormatException, I'd say the answer is "badly"...

        }// if(hasNextLine)

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

            try {
                inputDouble = Double.parseDouble(tempDouble);
            } catch (NumberFormatException nonNumericInput) {
                inputDouble = 0.0;
            }
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
        if(input.hasNextLine())
        {
            inputString = input.nextLine();
        }
        return inputString;
    }
}
