package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution122 {
    static class SolutionGreedy {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return maxProfit;
        }
    }

    static class SolutionDynamicProgram {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }


    public static void main(String[] args) {
        SolutionDynamicProgram solution = new SolutionDynamicProgram();
        int[] prices = {7,1,5,3,6,4};
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }
}
