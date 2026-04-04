package Lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int state) {
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        if (value != 0) {
            int current = this.result();
            this.clear();
            this.add(current / value);
        }
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        int current = this.result();
        int res = (int) Math.pow(current, exponent);
        this.clear();
        this.add(res);
        return this;
    }

    public AdvancedCalculator root(int order) {
        int current = this.result();
        int res = (int) Math.pow(current, 1.0 / order);
        this.clear();
        this.add(res);
        return this;
    }
}
