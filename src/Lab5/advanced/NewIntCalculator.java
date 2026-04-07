package Lab5.advanced;

public class NewIntCalculator extends ACalculator {
    @Override
    public void init(Object value) {
        state = (Integer) value;
    }

    public void add(Integer v) {
        state = (Integer) state + v;
    }

    public void subtract(Integer v) {
        state = (Integer) state - v;
    }

    public void multiply(Integer v) {
        state = (Integer) state * v;
    }
}