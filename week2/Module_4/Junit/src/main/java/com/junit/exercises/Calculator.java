package com.junit.exercises;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> operationHistory;

    public Calculator() {
        this.operationHistory = new ArrayList<>();
    }

    public int add(int a, int b) {
        int result = a + b;
        operationHistory.add(String.format("Added %d and %d to get %d", a, b, result));
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        operationHistory.add(String.format("Subtracted %d from %d to get %d", b, a, result));
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        operationHistory.add(String.format("Multiplied %d and %d to get %d", a, b, result));
        return result;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = (double) a / b;
        operationHistory.add(String.format("Divided %d by %d to get %f", a, b, result));
        return result;
    }

    public List<String> getHistory() {
        return new ArrayList<>(operationHistory);
    }

    public void clearHistory() {
        operationHistory.clear();
    }
}
