# Flexible Calculator

## Overview

This is a flexible, extensible calculator built in Java that supports basic arithmetic operations and is designed following the Open-Closed Principle. The architecture is suitable for IoC environments and makes it easy to add new operations without modifying the core `Calculator` class.

## Features

- Basic operations: ADD, SUBTRACT, MULTIPLY, DIVIDE
- Operation chaining (e.g., `((5 + 3) * 2) = 16`)
- IoC-compatible: inject dependencies via constructors
- Robust error handling (e.g., unsupported operations, division by zero)
- Unit tested with JUnit 5

## How to Build & Run

### Prerequisites

- Java 17+
- Maven 3+

### Steps

```bash
git clone <your-repo-url >
cd flexible-calculator
mvn clean install
```

### Run Tests

```bash
mvn test
```

## Design Principles Used

- **Strategy Pattern**: Each operation (Add, Subtract, etc.) is encapsulated in its own class.
- **Open-Closed Principle**: `Calculator` never changes when adding new operations.
- **IoC Friendly**: `OperationRegistry` and `Calculator` can be managed by DI frameworks (e.g., Spring).
- **Single Responsibility**: Each class has a clearly defined purpose.

## How to Add a New Operation (e.g., MODULO)

1. Extend `OperationStrategy` in a new class:

```java
public class ModuloOperation implements OperationStrategy {
    public Operation getOperation() { return Operation.MODULO; }
    public double apply(double num1, double num2) { return num1 % num2; }
}
```

2. Add the new enum constant in `Operation.java`.
3. Register it in `OperationRegistry`.

## Unit Testing

- Uses JUnit 5
- Covers:
  - Basic operations
  - Chained operations
  - Unsupported operation
  - Division by zero

## Time & Space Complexity

| Method        | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| `calculate()` | O(1)            | O(1)             |
| `chain()`     | O(n)            | O(1)             |

> Where `n` is the number of operations in the chain.

## Assumptions

- Operands are treated as `double` internally.
- Operation chaining uses an array of `[Operation, Operand]`.
- Division by zero throws `ArithmeticException`.

