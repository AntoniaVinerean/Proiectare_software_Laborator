package Lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator intC = new NewIntCalculator();

        intC.init(10);
        intC.add(5);
        intC.subtract(3);
        intC.multiply(2);
        System.out.println("Integer Result: " + intC.result());

        DoubleCalculator doubleC = new DoubleCalculator();

        doubleC.init(10.0);
        doubleC.add(5.0);
        doubleC.subtract(3.3);
        doubleC.multiply(2.2);
        System.out.println("Double Result: " + doubleC.result());
    }
}
