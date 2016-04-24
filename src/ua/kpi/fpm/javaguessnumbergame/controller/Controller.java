package ua.kpi.fpm.javaguessnumbergame.controller;

import java.util.Scanner;

import ua.kpi.fpm.javaguessnumbergame.model.Model;
import ua.kpi.fpm.javaguessnumbergame.view.View;

/**
 * Created by Anastasia Serhienko on 4/23/16.
 */
public class Controller {
    // The Constants
    public static final int RAND_MAX = 100;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method

    /**
     * The Work method.
     * Provides work with user.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        StringBuilder statistics = new StringBuilder();

        view.printMessage(View.GUESS_NUMBER);
        int userNumber = -1;

        while(model.getRandomNumber() != userNumber) {
            userNumber = inputIntValueWithScanner(sc, statistics);

            if (model.getRandomNumber() < userNumber) {
                view.printMessage(View.UNKNOWN_NUMBER_IS_LOWER);
                appendStatistics(statistics, Integer.toString(userNumber), View.UNKNOWN_NUMBER_IS_LOWER);
                model.setHigherLimit(userNumber - 1);
            } else if (model.getRandomNumber() > userNumber) {
                view.printMessage(View.UNKNOWN_NUMBER_IS_HIGHER);
                appendStatistics(statistics, Integer.toString(userNumber), View.UNKNOWN_NUMBER_IS_HIGHER);
                model.setLowerLimit(userNumber + 1);
            }
        }

        view.printMessage(View.SUCCESS);
        appendStatistics(statistics, Integer.toString(userNumber), View.SUCCESS);
        view.printMessage(View.GAME_STATISTICS);
        view.printMessage(statistics.toString());
    }

    // The Utility methods

    /**
     * This method reads input value with scanner and makes all needed checks of data.
     * @param sc Scanner
     * @param stat game statistics
     * @return valid input data
     */
    public int inputIntValueWithScanner(Scanner sc, StringBuilder stat) {
        boolean inputIsValid = false;
        int inputValue = 0;

        while (!inputIsValid) {
            view.printIntervalAndInputRequest(model.getLowerLimit(), model.getHigherLimit());

            while (!sc.hasNextInt()) {
                String message = View.WRONG_INPUT_INT_DATA + View.NOT_INTEGER;
                view.printMessage(message);
                appendStatistics(stat, sc.next(), message);
                view.printIntervalAndInputRequest(model.getLowerLimit(), model.getHigherLimit());
            }

            inputValue = sc.nextInt();

            if (inputValue >= model.getLowerLimit() && inputValue <= model.getHigherLimit()) {
                inputIsValid = true;
            } else {
                String message = View.WRONG_INPUT_INT_DATA + View.DATA_OUT_OF_RANGE;
                view.printMessage(message);
                appendStatistics(stat, Integer.toString(inputValue), message);
            }
        }

        return inputValue;
    }

    /**
     * This method adds new record to the game statistics.
     * @param stat game statistics
     * @param input number entered by user
     * @param msg system message which corresponds to the input number
     */
    private void appendStatistics(StringBuilder stat, String input, String msg) {
        stat.append(String.format(View.STATISTICS_FORMAT, model.getLowerLimit(), model.getHigherLimit(), input, msg));
    }
}
