package org.example.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 最长子字符串的长度(二)
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getResult(s));
    }

    public static int getResult(String s) {
        int status = 0b000;

        // map.get(i) 用于记录 状态i 出现的过的所有位置
        ArrayList<LinkedList<Integer>> map = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            map.add(new LinkedList<>());
        }

        map.get(0).add(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length() * 2; i++) {
            // 第二轮时，i>=s.length()，此时i需要对s.length()求余，避免后面越界
            char c = s.charAt(i % s.length());

            switch (c) {
                case 'l':
                    status ^= 0b100;
                    break;
                case 'o':
                    status ^= 0b010;
                    break;
                case 'x':
                    status ^= 0b001;
                    break;
            }

            if (i < s.length()) {
                // 第一轮时，i ∈ [0, s.length()), 左闭右开
                // 记录该状态出现过的所有位置
                map.get(status).add(i);
            }

            while (map.get(status).size() > 0) {
                // status状态最早出现的位置
                int earliest = map.get(status).getFirst();

                // i 是当前位置，和 earliest 位置的状态相同
                if (i - earliest > s.length()) {
                    // 如果 [earliest, i] 范围子串长度超过s串长度，则说明earliest左越界，应该尝试更大一点的earliest
                    map.get(status).removeFirst();
                } else {
                    // 如果 [earliest, i] 范围子串长度未超过s串长度，则该范围子串就是一个符合要求的子串，记录此时子串长度
                    maxLen = Math.max(maxLen, i - earliest);
                    break;
                }
            }
        }

        return maxLen;
    }
}
