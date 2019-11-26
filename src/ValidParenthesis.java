/*
 * Author: Mohan Gangadhar Gudey
 * Date: November 25, 2019
 * Description: Validate if the passed in parenthesis is valid or not
 * LeetCode problem no: 20
 */

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String... args) {
        String parenthesis = "({}{}{[]{}})";
        System.out.println(validateParenthesis(parenthesis));
    }

    // Assumptions: empty string is valid
    private static boolean validateParenthesis(String val) {
        if (val == null)
            return false;
        if (val.length() % 2 > 0)
            return false;

        Stack stack = new Stack();
        char[] chars = val.toCharArray();

        for (char ch : chars) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (stack.peek().equals(getOppositeParenthesis(ch))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    private static char getOppositeParenthesis(char ch) {
        switch (ch) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }
}
