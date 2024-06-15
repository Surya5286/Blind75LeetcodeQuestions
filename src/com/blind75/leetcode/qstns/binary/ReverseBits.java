package com.blind75.leetcode.qstns.binary;

public class ReverseBits {

    public static void main(String[] args) {

        int n = 00000000000000000000000000001011;

        // Time Complexity: O[32] ~ O[1]
        // Space Complexity : O[1]
        System.out.println(getReversedBit(n));

    }

    private static int getReversedBit(int n) {

        int reversedBit = 0;

        for (int i = 0; i < 32; i++) {
            reversedBit = reversedBit << 1;

            if( (n & 1) == 1)
                reversedBit = reversedBit | 1;

            n = n >> 1;
        }

        return reversedBit;
    }
}
