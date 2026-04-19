package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new DoubleCalculator();
    }

    @Test
    @DisplayName("Test adunare numere pozitive")
    public void testAddPositive() {
        calculator.init().add(10.5);
        Assertions.assertEquals(10.5, calculator.state, "Suma ar trebui să fie 10.5");
    }

    @Test
    @DisplayName("Test înmulțire cu zero")
    public void testMultiplyByZero() {
        calculator.init().add(10.0).multiply(0.0);
        Assertions.assertEquals(0.0, calculator.state, "Orice număr înmulțit cu 0 trebuie să fie 0");
    }

    @Test
    @DisplayName("Test scădere")
    public void testSubtract() {
        calculator.init().add(20.0).subtract(5.0);
        Assertions.assertEquals(15.0, calculator.state);
    }

    @Test
    @DisplayName("Test împărțire numere pozitive")
    public void testDividePositives() {
        calculator.init().add(10.0).divide(2.0);
        Assertions.assertEquals(5.0, calculator.state);
    }
}