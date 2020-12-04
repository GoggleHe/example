package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                System.out.println(prices[i] + " - " + min);
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        Solution121 solution121 = new Solution121();
        int i = solution121.maxProfit(price);
        System.out.println(i);
    }
}
