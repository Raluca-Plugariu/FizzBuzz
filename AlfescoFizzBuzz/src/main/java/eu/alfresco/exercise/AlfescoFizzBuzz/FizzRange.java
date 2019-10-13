package eu.alfresco.exercise.AlfescoFizzBuzz;

public class FizzRange {

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
