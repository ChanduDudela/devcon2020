package ctci.mediumproblems;

import java.util.Stack;

public class Calculator {
    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, NO_OP
    }

    int getPriority(Operator op) {
        switch (op) {
            case ADD:
            case SUBTRACT:
                return 1;
            case MULTIPLY:
            case DIVIDE:
                return 2;
            case NO_OP:
                return 0;
        }
        return 0;
    }

    Double operate(Double a, Operator op, Double b) {
        switch (op) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
            case NO_OP:
                return b;
        }
        return b;
    }

    void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
        while (numberStack.size() >= 2 && operatorStack.size() >= 1) {
            if (getPriority(futureTop) <= getPriority(operatorStack.peek())) {
                Double num1 = numberStack.pop();
                Double num2 = numberStack.pop();
                Operator op = operatorStack.pop();

                Double res = operate(num1, op, num2);
                numberStack.push(res);
            } else {
                break;
            }
        }
    }

    int parseNumericValue(String expression, int i) {
        StringBuilder sb = new StringBuilder();
        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
            sb.append(expression.charAt(i));
            i++;
        }
        return Integer.parseInt(sb.toString());
    }

    Operator parseOperatorValue(String expression, int i) {
        switch (expression.charAt(i)) {
            case '+': return Operator.ADD;
            case '-': return Operator.SUBTRACT;
            case '*': return Operator.MULTIPLY;
            case '/': return Operator.DIVIDE;
            default: return Operator.NO_OP;
        }
    }

    double calculate (String expression) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            try {
                double number = parseNumericValue(expression, i);
                numberStack.push(number);

                //move to the operator by incrementing
                i += Double.toString(number).length();

                Operator op = parseOperatorValue(expression, i);
                collapseTop(op, numberStack, operatorStack);
                operatorStack.push(op);
            } catch (NumberFormatException ex) {
                return Double.MIN_VALUE;
            }
        }

        //collapse rest of the stack
        collapseTop(Operator.NO_OP, numberStack, operatorStack);
        if (numberStack.size() == 1 && operatorStack.isEmpty()) {
            return numberStack.pop();
        }
        return 0;
    }
}
