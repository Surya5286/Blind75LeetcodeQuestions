package com.blind75.leetcode.qstns.arrays;

public class StockBuyNSellType1 {

    public static void main(String[] args) {
        int[] staticStockPrices = {5, 3, 2, 7, 9, 1, 4};

        System.out.println("Maximum Profits availed is : " + getMaxProfitsFromStockTrade(staticStockPrices));
    }

    private static int getMaxProfitsFromStockTrade(int[] staticStockPrices) {

        int minStockPrice = staticStockPrices[0];
        int currentProfits = 0, maxProfitsAvailed = 0;

        for (int i = 1; i < staticStockPrices.length; i++) {
            minStockPrice = Math.min(minStockPrice, staticStockPrices[i]);
            currentProfits = Math.max(currentProfits, staticStockPrices[i] - minStockPrice);
            maxProfitsAvailed = Math.max(maxProfitsAvailed, currentProfits);
        }

        return maxProfitsAvailed;
    }
}
