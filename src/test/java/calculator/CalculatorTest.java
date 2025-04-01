package calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        OperationRegistry registry = new OperationRegistry();
        registry.register(new AddOperation());
        registry.register(new SubtractOperation());
        registry.register(new MultiplyOperation());
        registry.register(new DivideOperation());
        calculator = new Calculator(registry);
    }

    @Test
    public void testAdd() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    public void testChain() {
        Object[][] operations = {
            {Operation.ADD, 3},
            {Operation.MULTIPLY, 2}
        };
        assertEquals(16.0, calculator.chain(5, operations));
    }

    @Test
    public void testUnsupportedOperation() {
        OperationRegistry registry = new OperationRegistry();
        Calculator calc = new Calculator(registry);
        assertThrows(UnsupportedOperationException.class, () ->
            calc.calculate(Operation.ADD, 1, 2));
    }

    @Test
    public void testDivideByZero() {
        OperationRegistry registry = new OperationRegistry();
        registry.register(new DivideOperation());
        Calculator calc = new Calculator(registry);
        assertThrows(ArithmeticException.class, () -> 
            calc.calculate(Operation.DIVIDE, 10, 0));
    }
}
