package Lab5.advanced;

public class DoubleCalculator extends ACalculator {
    @Override
    public void init(Object value) {
        state = (Double) value;
    }

    public void add(Double v) {
        state = (Double) state + v;
    }

    public void subtract(Double v) {
        state = (Double) state - v;
    }

    public void multiply(Double v) {
        state = (Double) state * v;
    }
}
