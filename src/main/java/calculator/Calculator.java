package calculator;

public class Calculator {
    private final OperationRegistry registry;

    public Calculator(OperationRegistry registry) {
        this.registry = registry;
    }

    public double calculate(Operation op, double num1, double num2) {
        return registry.get(op).apply(num1, num2);
    }

    public double chain(double initial, Object[][] operations) {
        double result = initial;
        for (Object[] step : operations) {
            Operation op = (Operation) step[0];
            double operand = ((Number) step[1]).doubleValue();
            result = calculate(op, result, operand);
        }
        return result;
    }
}
