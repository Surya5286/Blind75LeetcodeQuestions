package com.blind75.leetcode.qstns.Strings;

import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str1 = "()", str2 = "()[]{}", str3 = "", str4 = "(]", str5 = "{()[{()}]}", str6 = "([)]", str7 = "{[]}(";

        List<Boolean> booleanList = List.of(true, true, true, false, true, false, false);
        List<Boolean> validParentheses = List.of(isValidParentheses(str1), isValidParentheses(str2), isValidParentheses(str3), isValidParentheses(str4), isValidParentheses(str5), isValidParentheses(str6), isValidParentheses(str7));

        System.out.println("Input String : " + str5 + "\tIs ValidParentheses : " + isValidParentheses(str5));

        System.out.println("*****************************************************");

        System.out.println("Test Multiple test scenarios");


        if (booleanList.equals(validParentheses))
            System.out.println("Successfully evaluated all the samples and the results are as expected : " + booleanList);
        else
            System.out.println("Successfully evaluated all the samples and the results are not as expected. " + "\nExpected List of results : " + booleanList + "\nActual List of results : " + validParentheses);

        System.out.println("*****************************************************");

    }

    /**
     * @param str - Incoming Patntheses String
     * @return - Returns the Boolean Value [true, false]
     */
    private static boolean isValidParentheses(String str) {

        Stack<Character> charStack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                charStack.push(ch);
            } else {
                if (charStack.isEmpty()) return false;
                char popChar = charStack.pop();
                if (!((ch == ')' && popChar == '(') || (ch == ']' && popChar == '[') || (ch == '}' && popChar == '{')))
                    return false;
            }
        }
        return charStack.isEmpty();
    }
}
