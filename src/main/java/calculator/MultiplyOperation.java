package calculator;

public class MultiplyOperation implements OperationStrategy {
    public Operation getOperation() { return Operation.MULTIPLY; }
    public double apply(double num1, double num2) { return num1 * num2; }
}
