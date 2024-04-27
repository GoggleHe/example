package org.example.limiter;

import java.util.Scanner;

public class Main {

    static int[] gems;
    static int money;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = in.nextInt();
        }
        money = in.nextInt();

        int maxCnt = getResult(gems, money);
        System.out.println(maxCnt);
    }

    public static int getResult(int[] gems, int money) {

        // for (int i = 0; i < gems.length; i++) {
        //     for (int j = 1; j < gems.length; j++) {

        //     }
        // }
        int maxCnt = 0;
        int i = 0;
        int j = 1;

        while (i < gems.length) {
            while (j < gems.length) {
                if (i >= j) {
                    break;
                }
                int sum = 0;
                int k = i;
                while (k < j) {
                    sum += gems[k];
                    k++;
                }
                if (sum < money) {
                    maxCnt = Math.max(maxCnt, j - i);
                    j++;
                } else if (sum == money) {
                    maxCnt = Math.max(maxCnt, j - i);
                    break;
                } else {
                    i++;
                }
            }
        }
        return maxCnt;
    }
}
