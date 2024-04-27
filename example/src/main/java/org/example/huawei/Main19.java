package org.example.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 转盘寿司
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = prices.length;

        // 记录题解
        int[] res = Arrays.copyOf(prices, n);

        // 单调栈，栈底到栈顶单调递增，压栈元素是栈顶元素在nums顺序后面的值
        // 每当压栈时，比较栈顶元素 > 压栈元素？若是，则说明找到了栈顶元素的下一个更小值，此时弹栈，压栈元素继续和新栈顶元素比较大小，直到栈顶元素 <= 压栈元素，则停止比较，执行压栈
        LinkedList<Integer> stack = new LinkedList<>(); // 栈中记录是prices元素的索引

        // 这里循环两轮，因为一轮循环可能无法确保所有值都能找到下一个更小值
        for (int j = 0; j < n * 2; j++) {
            // prices_j 是压栈(索引对应的)元素
            int prices_j = prices[j % n]; // 索引 j % n 是为了让第二轮遍历时，继续从prices的0索引开始

            while (stack.size() > 0) {
                // prices[i] 是栈顶(索引对应的)元素
                int i = stack.getLast();

                if (prices[i] > prices_j) {
                    // 如果栈顶元素 > 压栈元素，则说明找到了栈顶元素的下一个更小值，此时栈顶元素弹出,压栈元素继续和新的栈顶元素比较
                    stack.removeLast();
                    // 题目要统计当前元素和其下一个更小值元素之和
                    res[i] += prices_j;
                } else {
                    break;
                }
            }

            // 只有第一轮遍历时，才允许压栈，第二轮遍历时，只进行比较
            if (j < n) {
                stack.add(j);
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int num : res) {
            sj.add(num + "");
        }
        System.out.println(sj);
    }
}
