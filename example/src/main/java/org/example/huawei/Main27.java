package org.example.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 攀登者2
 */
public class Main27 {
    // 输入处理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int strength = Integer.parseInt(sc.nextLine());

        System.out.println(getResult(heights, strength));
    }

    // 算法实现（本题实际考试为核心代码模式，因此考试时只需要写出此函数实现即可）
    public static int getResult(int[] heights, int strength) {
        // 记录可攀登的山峰索引
        HashSet<Integer> idxs = new HashSet<>();

        // 正向攀登
        climb(heights, strength, idxs, true);

        // 逆序攀登
        reverse(heights);
        climb(heights, strength, idxs, false);

        return idxs.size();
    }

    public static void climb(int[] heights, int strength, HashSet<Integer> idxs, boolean direction) {
        // 找到第一个地面位置
        int j = 0;
        while (j < heights.length && heights[j] != 0) {
            j++;
        }

        int cost = 0; // 攀登体力总消耗（包括上山，下山）
        //    int upCost = 0; // 上山体力消耗
        //    int downCost = 0; // 下山体力消耗

        // 开始攀登
        for (int i = j + 1; i < heights.length; i++) {
            // 如果遇到了新的地面，则从新的地面位置重新计算攀登消耗的体力
            if (heights[i] == 0) {
                cost = 0;
                //        upCost = 0;
                //        downCost = 0;
                continue;
            }

            int diff = heights[i] - heights[i - 1]; // diff记录高度差

            if (diff > 0) {
                // 如果过程是上坡
                cost += diff * 3;
                //        upCost += diff * 2; // 则上山时，体力消耗 = 高度差 * 2
                //        downCost += diff; // 相反的下山时，体力消耗 = 高度差 * 1

                // 由于 height[i] > heights[i-1]，因此如果 height[i] > heights[i+1] 的话，位置 i 就是山顶
                if (i + 1 >= heights.length || heights[i] > heights[i + 1]) {
                    // 计算攀登此山顶的上山下山消耗的体力和
                    if (cost < strength) {
                        //          if (upCost + downCost <= strength) {
                        // 如果小于自身体力，则可以攀登
                        if (direction) {
                            idxs.add(i);
                        } else {
                            idxs.add(heights.length - i - 1); // 需要注意，逆序heights数组后，我们对于的山峰位置需要反转
                        }
                    }
                }

            } else if (diff < 0) {
                // 如果过程是下坡
                cost -= diff * 3;
                //        upCost -= diff; // 则上山时，体力消耗 = 高度差 * 1
                //        downCost -= diff * 2; // 相反的下山时，体力消耗 = 高度差 * 2

                // heights[i] < heights[i-1]，因此位置i不可能是山顶
            }
        }
    }

    public static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
