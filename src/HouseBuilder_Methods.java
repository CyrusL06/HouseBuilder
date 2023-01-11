
import javax.swing.JOptionPane;


/*
* HouseBuilder_Methods - description 
*
* @author Cyrus Lorenzo
* @since 2-Nov-2022
    Added floors in the project for fun
 */
public class HouseBuilder_Methods {

    // REUSABLE VARIABLES and METHODS (below this line)........................
    static final String TITLE = "House Builder";

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
    public static void main(String[] args) {

        start();
        run();
        end();

    }

    /**
     * Starts the application and welcomes user with a dialog
     */
    private static void start() {
        // Call output to generate a dialog and attach the title global variable
        output("Welcome to " + TITLE);
    }

    /**
     * Ends the application with a dialog and terminates the application
     */
    private static void end() {
        // Call output dialog and attach global title then terminate the app
        output("Thanks for using " + TITLE);
        System.exit(0);                                 // Terminates the app
    }

    /**
     * Outputs text in a more visual graphical dialog
     *
     * @param text the text to display
     */
    private static void output(String text) {
        JOptionPane.showMessageDialog(null, text, TITLE,
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Ask the user if they want to play again, in a dialog box
     *
     * @return true (yes, play again), false (no)
     */
    private static boolean playAgain() {
        // Send the yesNo method the play again message
        return yesNo("Do you want to play again?");
    }

    /**
     * Ask the user a yes and no question, in a confirm dialog box
     *
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    private static boolean yesNo(String text) {
        // Store the user's response in a variable from what they clicked on
        // when the dialog appears only showing "yes" and "no" buttons for 
        // the user to choose from         
        int response = JOptionPane.showConfirmDialog(null, text, TITLE,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;            // The user's response picked yes
        } else {
            return false;           // The user's response picked no
        }
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int inputInteger(String text) {
        // Store user's response from what they inputted in a dialog
        String value = input(text);
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty
        while (value.equals("")) {
            value = input(ERROR + text);
        }
        // Now convert what the user entered into an integer
        int number = Integer.parseInt(value);
        return number;        // Then return that number value      
    }

    /**
     * Asks the user for a string input in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid string
     */
    private static String input(String text) {
        // Store the user's response in a variable from what they typed into
        // a input dialog
        String value = JOptionPane.showInputDialog(null,
                text, TITLE, JOptionPane.QUESTION_MESSAGE);
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty and clicked "ok" or
        // they clicked "cancel" or the "X"
        while (value == null || value.equals("")) {
            // Have the user enter again (with error message attached)
            value = JOptionPane.showInputDialog(null, ERROR + text, TITLE,
                    JOptionPane.QUESTION_MESSAGE);
        }
        // Once they have entered a value, return it
        return value;
    }

    /**
     * Determines if a number if odd or even
     *
     * @param number the number to check
     * @return true (if even), false (if odd)
     */
    private static boolean isEven(int number) {
        if (number % 2 == 0) {      // Number divides evenly by zero
            return true;
        } else {                      // Number does not divide evenly by zero
            return false;
        }
    }

    static final String ROOF_LEFT = "/";
    static final String ROOF_RIGHT = "\\";
    static final String WALL = "|";
    static final String FLOOR = "_";
    static final String STEPS = "**";
    static final String WALK = "*";
    static final String SPACE = " ";

// run method it runs the logic for the house builder in a game loop
    private static void run() {
        //create do whle loop
        do {
            int base = inputInteger("Enter the base for the house");
            if (isEven(base) == true) {
                roof(base);
                house(base);
                walk(base);

            } else {
                output("Cannot draw a house with a base of " + base);
            }
        } while (playAgain() == true);
    }

    private static void roof(int base) {

        //calculate the half way point (adjusted)
        int half = base / 2 - 1;

        //Draw the roof up to (but not including) the ceiling
        for (int i = 0; i < half; i++) {
            // Draw the leading spaces
            for (int j = half; j > i; j--) {

                System.out.print(SPACE);
            }
            // Draw the Frony Roof Piece
            System.out.print(ROOF_LEFT);
            //Draw middle spaces
            for (int j = 0; j < i * 2; j++) {

                System.out.print(SPACE);
            }

            //Draw out the back roof piece
            System.out.println(ROOF_RIGHT);
        }
        // Now draw the last part of the roof with the ceiling 
        System.out.print(ROOF_LEFT);
        for (int j = 0; j < base - 2; j++) {
            System.out.print(FLOOR);
        }
        System.out.println(ROOF_RIGHT);
    }

    private static void house(int base) {

        // calculate the half way pint (adjusted)
        int half = base / 2 - 1;
        // Draw the walls up to (but not including)the floor
        for (int i = 0; i < half; i++) {
            System.out.print(WALL);
            // now the middle space
            for (int j = 0; j < base - 2; j++) {

                System.out.print(SPACE);
            }
            System.out.println(WALL);

            //Now draw the floor
            System.out.print(WALL);
            for (int j = 0; j < base - 2; j++) {
                System.out.print(FLOOR);
            }
            System.out.println(WALL);

        }

    }

    private static void walk(int base) {
        //Calulate the halfway point (adjusted)
        int half = base / 2 - 1;
        //First draw the spaces up to the steps 
        for (int i = 0; i < half; i++) {
            System.out.print(SPACE);
        }
        System.out.println(STEPS);
        //now draw the spaces up to the sidewalk
        for (int i = 0; i < half; i++) {
            System.out.print(SPACE);
        }
        //Now draw the sidewalk
        for (int i = 0; i < base; i++) {
            System.out.print(WALK);
        }
        System.out.println("");

    }

}
