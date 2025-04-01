package calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<Operation, OperationStrategy> strategies = new HashMap<>();

    public void register(OperationStrategy strategy) {
        strategies.put(strategy.getOperation(), strategy);
    }

    public OperationStrategy get(Operation operation) {
        if (!strategies.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation not supported: " + operation);
        }
        return strategies.get(operation);
    }
}
