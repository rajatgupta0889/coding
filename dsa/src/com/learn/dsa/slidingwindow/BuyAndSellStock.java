package com.learn.dsa.slidingwindow;

public class BuyAndSellStock {

    /*
    * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    * 121. Best Time to Buy and Sell Stock
    * */

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        int result = buyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result); // 5
        result = buyAndSellStock.maxProfit(new int[]{7,6,4,3,1});
        System.out.println(result); // 0
    }
}
