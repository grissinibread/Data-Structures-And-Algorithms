package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Balanced {

    private final List<Character> leftExpression = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightExpression = Arrays.asList(')', '>', ']', '}');

    public Boolean balance(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftExpression(ch)) {
                stack.push(ch);
            }

            if(isRightExpression(ch)) {
                if (stack.isEmpty()) return Boolean.FALSE;

                var top = stack.pop();
                if (match(top, ch)) return Boolean.FALSE;
            }
        }

        return stack.isEmpty();
    }

    private Boolean isLeftExpression(char ch) {
        return leftExpression.contains(ch);
    }

    private Boolean isRightExpression(char ch) {
        return rightExpression.contains(ch);
    }

    private Boolean match(char left, char right) {
        return leftExpression.indexOf(left) == rightExpression.indexOf(right);
    }
}