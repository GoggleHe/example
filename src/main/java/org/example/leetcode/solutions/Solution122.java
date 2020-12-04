package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int[] prices = {1, 2, 1, -1, 0, -3};
        int i = solution122.maxProfit(prices);
        System.out.println(i);
    }
}
