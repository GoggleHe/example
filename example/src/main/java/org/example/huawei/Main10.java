package org.example.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 小朋友来自多少小区（Java & JS & Python & C）
 * 在线OJ刷题
 * 题目详情 - 小朋友来自多少分区 - Hydro
 * <p>
 * 题目描述
 * 幼儿园组织活动，老师布置了一个任务：
 * <p>
 * 每个小朋友去了解与自己同一个小区的小朋友还有几个。
 * <p>
 * 我们将这些数量汇总到数组 garden 中。
 * <p>
 * 请根据这些小朋友给出的信息，计算班级小朋友至少来自几个小区？
 * <p>
 * 输入描述
 * 输入：garden[] = {2, 2, 3}
 * <p>
 * 输出描述
 * 输出：7
 * <p>
 * 备注
 * garden 数组长度最大为 999
 * 每个小区的小朋友数量最多 1000 人，也就是 garden[i] 的范围为 [0, 999]
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getResult(nums));
        } catch (Exception e) {
            System.out.println("0");
        }
    }

    public static int getResult(int[] nums) {
        // num是反馈，cnts[num]是给出相同反馈的（小朋友）数量
        HashMap<Integer, Integer> cnts = new HashMap<>();

        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        // ans 记录题解
        int ans = 0;
        for (int key : cnts.keySet()) {
            // key是反馈，假设某小朋友反馈有key个人和自己一个小区，那么该小区总人数为total = key+1
            int total = key + 1;
            ans += Math.ceil(cnts.get(key) * 1.0 / total) * total;
        }

        return ans;
    }
}
