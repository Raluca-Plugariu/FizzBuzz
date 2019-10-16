package eu.alfresco.exercise.AlfescoFizzBuzz.dto;

import java.io.Serializable;

public class FizzRange implements Serializable {

    /**
     * Lower limit of fizz range.
     */
    private int min;

    /**
     * Upper limit of fizz range.
     */
    private int max;

    public FizzRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public FizzRange() {

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
