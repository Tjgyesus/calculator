package calculator;

public class DivideOperation implements OperationStrategy {
    public Operation getOperation() { return Operation.DIVIDE; }
    public double apply(double num1, double num2) {
        if (num2 == 0) throw new ArithmeticException("Division by zero");
        return num1 / num2;
    }
}
