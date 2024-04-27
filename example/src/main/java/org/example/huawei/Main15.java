package org.example.huawei;

import java.util.Scanner;

/**
 * 分披萨
 */
public class Main15 {
    static int[] pizza;

    // 缓存
    static long[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 披萨数量（奇数个）
        int n = sc.nextInt();

        // n个披萨的大小（各不相同）
        pizza = new int[n];
        for (int i = 0; i < n; i++) {
            pizza[i] = sc.nextInt();
        }

        // ans记录"吃货"能获得的最大披萨大小
        long ans = 0;
        // i 指向首轮被"吃货"选取的披萨位置，可以理解为缺口位置，相当于给环切了一个口
        for (int i = 0; i < n; i++) {
            // i - 1 是缺口的左边披萨，check函数作用是防止 i - 1 越界, 进行绕环运动
            // i + 1 是缺口的右边披萨，check函数作用是防止 i + 1 越界，进行绕环运动
            // recursive的作用求解是"吃货"从缺失了 第 i 块的披萨铁盘 开始选，最终可得的最大披萨大小，
            // 而第 i 块是首轮就被"吃货"拿走的，因此是recursive + pizza[i]
            ans = Math.max(ans, recursive(check(i - 1), check(i + 1)) + pizza[i]);
        }

        System.out.println(ans);
    }

    public static long recursive(int l, int r) {
        // 进入递归前，"吃货"已经拿了披萨，因此进入递归后，轮到"馋嘴"拿
        // 而"馋嘴"拿披萨的策略固定是：缺口左右两边中较大的那块
        if (pizza[l] > pizza[r]) { // 注意披萨大小各部相同，因此要么左边大，要么右边大，不存在相等的情况
            // 拿走第 l 块，因此缺口左边的位置变为 l - 1
            l = check(l - 1);
        } else {
            // 拿走第 r 块，因此缺口右边的位置变为 r + 1
            r = check(r + 1);
        }

        if (l == r) {
            // 当 l == r 是，说明只剩一块披萨了，由于奇数个披萨，且"吃货"第一个拿，因此最后一个也是"吃货"拿
            return pizza[l];
        } else {
            // 如果还剩多块披萨，那么"吃货"有两种选择：
            // 1、拿缺口左边的披萨
            // 2、拿缺口右边的披萨
            // 因此这里直接开两个递归分支，最终结果取较大值
            return Math.max(recursive(check(l - 1), r) + pizza[l], recursive(l, check(r + 1)) + pizza[r]);
        }
    }

    public static long recursive_cache(int l, int r) {
        if (pizza[l] > pizza[r]) {
            l = check(l - 1);
        } else {
            r = check(r + 1);
        }

        // 缓存优化，如果对应缺口状态的披萨铁盘结果已经算过了，则无需再次重复递归
        if (cache[l][r] > 0) {
            return cache[l][r];
        }

        if (l == r) {
            // 缓存对应缺口状态下，吃货可得的最大披萨大小
            cache[l][r] = pizza[l];
        } else {
            // 缓存对应缺口状态下，吃货可得的最大披萨大小
            cache[l][r] =
                    Math.max(recursive(check(l - 1), r) + pizza[l], recursive(l, check(r + 1)) + pizza[r]);
        }

        return cache[l][r];
    }

    public static int check(int idx) {
        if (idx < 0) {
            idx = pizza.length - 1;
        } else if (idx >= pizza.length) {
            idx = 0;
        }

        return idx;
    }
}
