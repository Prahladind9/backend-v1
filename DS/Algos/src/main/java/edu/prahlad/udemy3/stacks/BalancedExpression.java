package edu.prahlad.udemy3.stacks;

import java.util.Stack;

public class BalancedExpression {
    public boolean isBalancedSupportAll(final String input) {
        final Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;
                if (bracketsMatch(stack.pop(), ch)) return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(final char ch) {
        return ch == '(' || ch == '<' || ch == '[' || ch == '{';
    }

    private boolean isRightBracket(final char ch) {
        return ch == ')' || ch == '>' || ch == ']' || ch == '}';
    }

    private boolean bracketsMatch(final char left, final char right) {
        return (right == ')' && left != '(') ||
                (right == '>' && left != '<') ||
                (right == ']' && left != '[') ||
                (right == '}' && left != '{');
    }

    public boolean isBalanced(final String input) {
        final Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(')
                stack.push(ch);

            if (ch == ')') {
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        //EdgeCases
        //(
        //((
        //)(

        BalancedExpression balancedExpression = new BalancedExpression();
        System.out.println(balancedExpression.isBalanced("(1+2)"));
        System.out.println(balancedExpression.isBalanced("((1+2)"));
        System.out.println(balancedExpression.isBalanced(")1+2("));
        System.out.println(balancedExpression.isBalanced("(1+2"));

        System.out.println(balancedExpression.isBalancedSupportAll("(1+2>"));

    }
}
