package com.blind75.leetcode.qstns.binary;

public class SumOfTwoIntegers {

    public static void main(String[] args) {

        /*
            Given two integers a and b,
            return the sum of the two integers without using arithmetic operators.
        */

        int a = 1, b = 2;

        // Sum Of 2 integers Using Bitwise Operators
        // Time Complexity : O[32] ~ O[1]
        // Space Complexity: 0[1]
        System.out.println(getSumOfTwoAttributesUsingBinaryOperators(a, b));

    }

    private static int getSumOfTwoAttributesUsingBinaryOperators(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
