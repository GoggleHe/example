package org.example.huawei;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 橱窗中宝石的总数量
        int n = sc.nextInt();

        // n个宝石的价格
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = sc.nextInt();
        }

        // 你拥有的钱
        int v = sc.nextInt();

        // 记录题解
        int ans = 0;

        // 双指针
        int l = 0;
        int r = 0;

        // 双指针范围内的和
        int window_sum = 0;

        outer:
        while (r < n) {
            // 加入r指针指向的元素
            window_sum += gems[r];

            if (window_sum <= v) {
                // 如果总和不超过拥有的钱，则继续加入后面的
                r++;
            } else {
                // 如果总和超过了拥有的钱，则 [l, r-1] 范围的宝石是能够买下的，记录此时的宝石数量 r-1 - l + 1
                ans = Math.max(ans, r - l);

                while (l < r) {
                    // 由于纳入r位置宝石后，总和超过了拥有的钱，因此我们尝试丢弃l指针宝石，即l++
                    window_sum -= gems[l++];
                    if (window_sum <= v) {
                        // 如果丢弃l宝石后，总和不超过拥有的钱，则继续纳入r后面的宝石
                        r++;
                        continue outer;
                    }
                }

                // 如果把 l ~ r - 1 范围宝石都丢弃了，总和任然超过拥有的钱，那么就r宝石的价值就超过了手中的钱，此时双指针范围内不能包含r位置
                // 此时可以将l,r全部移动到r+1位置
                l = ++r;
                window_sum = 0;
            }
        }

        // 收尾操作
        if (window_sum <= v) {
            ans = Math.max(ans, r - l);
        }

        System.out.println(ans);
    }
}
