package edu.prahlad.codeWithMosh3.part1.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    private boolean isBalancedSupportAll(final String input){
        final Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray()){
            if(isLeftBracket(ch))
                stack.add(ch);

            if(isRightBracket(ch)){
                if(stack.empty()) return false;

                if(!bracketsMatch(stack.pop(), ch)) return false;
            }

        }
        return stack.empty();
    }

    private boolean isLeftBracket(final char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(final char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(final char left, final char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public static void main(String[] args) {
        BalancedExpression balancedExpression = new BalancedExpression();
        System.out.println(balancedExpression.isBalancedSupportAll("(1+2>"));
        System.out.println(balancedExpression.isBalancedSupportAll("(1+2)]"));
        System.out.println(balancedExpression.isBalancedSupportAll("[(1+2)]"));
    }
}
