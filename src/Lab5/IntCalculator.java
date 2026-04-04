package Lab5;

public class IntCalculator {
    protected int state;

    public IntCalculator (int state) {
        this.state = state;
    }

    public IntCalculator add(int value) {
        this.state = state+ value;
        return this;
    }

    public IntCalculator substract(int value){
        this.state = state- value;
        return this;
    }

    public IntCalculator multiply(int value){
        this.state = state*value;
        return this;
    }

    public int result(){
        return this.state;
    }

    public void clear(){
        this.state = 0;
    }
}
