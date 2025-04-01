package calculator;

public class SubtractOperation implements OperationStrategy {
    public Operation getOperation() { return Operation.SUBTRACT; }
    public double apply(double num1, double num2) { return num1 - num2; }
}
