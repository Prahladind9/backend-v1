package edu.prahlad.codeWithMosh2.part1.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

    public boolean isBalancedExpression(String expression) {
        if(expression == null)
            throw new IllegalArgumentException();

        final Stack<Character> stack = new Stack<>();
        for (Character ch : expression.toCharArray()) {
            if (isLeftBrackets(ch)) {
                stack.push(ch);
            }

            if (isRightBrackets(ch)) {
                if (stack.empty()) {
                    return false;
                }

                if (!isExpressionMatched(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isExpressionMatched(Character left, Character right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isLeftBrackets(final Character ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBrackets(final Character ch) {
        return rightBrackets.contains(ch);
    }

    public static void main(String[] args) {
        final BalancedExpression expression = new BalancedExpression();
        System.out.println(expression.isBalancedExpression("(1_2)"));
        System.out.println(expression.isBalancedExpression("(1)_2)"));
        System.out.println(expression.isBalancedExpression("<{[()]}>"));
        System.out.println(expression.isBalancedExpression(null));
    }
}
