package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution605 {
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
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

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean leftEmpty = i <= 0 || flowerbed[i - 1] == 0;
            boolean rightEmpty = i >= flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (flowerbed[i] == 0 && leftEmpty && rightEmpty) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
