package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 项目排期
 */
public class Java22 {
    static Integer[] balls;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        balls = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        n = Integer.parseInt(sc.nextLine());

        System.out.println(getResult());
    }

    public static int getResult() {
        // 这里对balls降序，有利于降低后面回溯操作的复杂度
        Arrays.sort(balls, (a, b) -> b - a);

        // 二分范围：即每个桶的容量最小，最大值
        int min = balls[0]; // 桶至少要有max(balls)的容量
        int max = Arrays.stream(balls).reduce(Integer::sum).get(); // 当只有一个桶时，此时该桶容量要装下所有balls

        // 记录题解
        int ans = max;

        // 二分找中间值作为桶容量
        while (min <= max) {
            int mid = (min + max) >> 1;

            if (check(0, new int[n], mid)) {
                // 如果k个mid容量的桶，可以装完所有balls，那么mid容量就是一个可能解，但不一定是最优解，我们应该尝试更小的桶容量
                ans = mid;
                max = mid - 1;
            } else {
                // 如果k个mid容量的桶，无法装完所有balls，那么说明桶容量取小了，我们应该尝试更大的桶容量
                min = mid + 1;
            }
        }

        return ans;
    }

    /**
     * @param index   当前轮次要被装入的球的索引（balls数组索引）
     * @param buckets 桶数组，buckets[i]记录的是第 i 个桶已使用的容量
     * @param limit   每个桶的最大可使用容量
     * @return k个桶（每个桶容量limit）是否可以装下balls中所有球
     */
    public static boolean check(int index, int[] buckets, int limit) {
        // 如果balls已经取完，则说明k个limit容量的桶，可以装完所有balls
        if (index == balls.length) return true;

        // select是当前要装的球
        int selected = balls[index];

        // 遍历桶
        for (int i = 0; i < buckets.length; i++) {
            // 剪枝优化
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;

            // 如果当前桶装了当前选择的球后不超过容量限制，则可以装入
            if (selected + buckets[i] <= limit) {
                buckets[i] += selected;
                // 递归装下一个球
                if (check(index + 1, buckets, limit)) return true;
                // 如果这种策略无法装完所有球，则回溯
                buckets[i] -= selected;
            }
        }

        return false;
    }
}
