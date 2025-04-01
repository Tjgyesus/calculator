package calculator;

public class AddOperation implements OperationStrategy {
    public Operation getOperation() { return Operation.ADD; }
    public double apply(double num1, double num2) { return num1 + num2; }
}
