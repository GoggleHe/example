package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Solution134 solution134 = new Solution134();
        int i = solution134.canCompleteCircuit(gas, cost);
        System.out.println(i);

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1, totalGas = 0, totalCost = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                int j = i;
                while (i != j && totalGas >= 0) {
                    totalGas += gas[j];
                    totalGas -= cost[j];
                    if (totalGas < 0) {
                        break;
                    }
                    j = j < n ? j + 1 : 0;
                }
            }
        }
        return -1;
    }
}
