package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (i - 1 < 0 && i + 1 >= flowerbed.length && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i - 1 < 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i + 1 == flowerbed.length && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            } else if (i - 1 >= 0 && i + 1 < flowerbed.length && flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowered = {0};
        int n = 1;
        Solution605 solution605 = new Solution605();
        boolean b = solution605.canPlaceFlowers(flowered, n);
        System.out.println(b);
    }
}
