package ua.kpi.fpm.javaguessnumbergame.view;

/**
 * Created by Anastasia Serhienko on 4/23/16.
 */
public class View {
    // Text's constants
    public static final String GUESS_NUMBER = "GUESS NUMBER! ";
    public static final String INPUT_INT_DATA = "Input INT value: ";
    public static final String CURRENT_INTERVAL = "Number is in interval [%d, %d]\n";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String NOT_INTEGER = "Data must be integer. ";
    public static final String DATA_OUT_OF_RANGE = "Your number is out of possible range! ";
    public static final String SUCCESS = "<<<<< Congratulations! You win! >>>>> ";
    public static final String GAME_STATISTICS = "Your game statistics:\nInterval   Input   System message";
    public static final String STATISTICS_FORMAT = "[%d, %d]   %s    %s\n";
    public static final String UNKNOWN_NUMBER_IS_LOWER = "Unknown number is lower. Keep trying! ";
    public static final String UNKNOWN_NUMBER_IS_HIGHER = "Unknown number is higher. Keep trying! ";

    /**
     * This method prints text message.
     * @param message text to print
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * This method prints current interval where unknown number can be and also prints an input request.
     * @param lowerLimit lower limit of interval
     * @param higherLimit higher limit of interval
     */
    public void printIntervalAndInputRequest(int lowerLimit, int higherLimit) {
        System.out.printf(CURRENT_INTERVAL, lowerLimit, higherLimit);
        printMessage(INPUT_INT_DATA);
    }
}
