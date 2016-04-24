package ua.kpi.fpm.javaguessnumbergame.model;

import ua.kpi.fpm.javaguessnumbergame.controller.Controller;

/**
 * Created by Anastasia Serhienko on 4/23/16.
 */
public class Model {
    private int randomNumber;
    private int lowerLimit;
    private int higherLimit;

    // The Program logic

    /**
     * Constructor of Model.
     * Sets limits and chooses random number.
     */
    public Model() {
        this.lowerLimit = 0;
        this.higherLimit = Controller.RAND_MAX;
        this.randomNumber = rand();
    }

    public void setLowerLimit(int limit) {
        this.lowerLimit = limit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setHigherLimit(int limit) {
        this.higherLimit = limit;
    }

    public int getHigherLimit() {
        return higherLimit;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * in this method set random intNumber from 0 to 100
     * @param min lower limit of random
     * @param max higher limit of random

     * @return random int
     */
    public int rand(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    /**
     * in this method set random intNumber from 0 to RAND_MAX
     * @return random int
     */
    public int rand() {
        return rand(0, Controller.RAND_MAX);
    }
}
