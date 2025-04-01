package calculator;

public interface OperationStrategy {
    Operation getOperation();
    double apply(double num1, double num2);
}
