package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    @Test
    public void testDivide() {
        NewIntCalculator calculator = new NewIntCalculator();
        calculator.init().add(10).divide(2);
        Assertions.assertEquals(5, calculator.state);
    }

    @Test
    public void testDivideByZero() {
        NewIntCalculator calculator = new NewIntCalculator();
        calculator.init().add(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
    }
}