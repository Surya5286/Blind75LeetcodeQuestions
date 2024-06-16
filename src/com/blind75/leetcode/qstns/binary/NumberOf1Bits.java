package com.blind75.leetcode.qstns.binary;

public class NumberOf1Bits {

    public static void main(String[] args) {

        // The binary representation of an unsigned integer
        int n = 00000000000000000000000000001011;

        // Time Complexity: O[32] ~ O[1]
        // Space Complexity : O[1]
        System.out.println(getNumberOf1BitsFromTheGivenInputInteger(n));

    }

    private static int getNumberOf1BitsFromTheGivenInputInteger(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            int mask =  1 << i;
            if( (n & mask) != 0) count++;
        }
        return count;
    }
}
