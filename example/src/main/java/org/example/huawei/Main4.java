package org.example.huawei;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取字符串中的最长合法简单数学表达式
 * <p>
 * 提取字符串中的最长合法简单数学表达式，字符串长度最长的，并计算表达式的值。如果没有，则返回 0 。
 * <p>
 * 简单数学表达式只能包含以下内容：
 * <p>
 * 0-9数字，符号+-*
 * 说明：
 * <p>
 * 所有数字，计算结果都不超过long
 * 如果有多个长度一样的，请返回第一个表达式的结果
 * 数学表达式，必须是最长的，合法的
 * 操作符不能连续出现，如 +--+1 是不合法的
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static long getResult(String s) {
        String maxLenExp = getMaxLenExp(s);

        if (maxLenExp.length() == 0) {
            return 0;
        } else {
            return calcExpStr(maxLenExp);
        }
    }

    public static String getMaxLenExp(String s) {
        Matcher matcher = Pattern.compile("((\\d+[+*-])*\\d+)").matcher(s);

        String maxLenExp = "";

        while (matcher.find()) {
            String exp = matcher.group(0);

            if (exp.length() > maxLenExp.length()) {
                maxLenExp = exp;
            }
        }

        return maxLenExp;
    }

    public static long calcExpStr(String exp) {
        // 这里在表达式结尾追加"+0"是为了避免后面收尾操作，不理解的话，可以去掉此步，测试下"1-2"
        exp += "+0";

        // 记录表达式中各块的操作数
        LinkedList<Long> stack = new LinkedList<>();
        // 各块操作数的"值"部分的缓存容器
        StringBuilder numStr = new StringBuilder();
        // 各块操作数的"系数"部分，默认为1
        long num_coef = 1;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c >= '0' && c <= '9') {
                numStr.append(c);
                continue;
            }

            // 如果扫描到的字符c是运算符，那么该运算符打断了前面操作数的扫描，前面操作数 = 系数 * 值
            long num = num_coef * Long.parseLong(numStr.toString());
            stack.add(num);

            // 清空缓存容器，用于下一个操作数的”值“记录
            numStr = new StringBuilder();

            switch (c) {
                case '+':
                    // 如果运算符是加法，则后一个操作数的系数为1
                    num_coef = 1;
                    break;
                case '-':
                    // 如果运算符是减法，则后一个操作数的系数为-1
                    num_coef = -1;
                    break;
                case '*':
                    // 如果运算符是乘法，则后一个操作数的系数为栈顶值，比如2*3，其中2可以当作3的系数
                    num_coef = stack.removeLast();
                    break;
            }
        }

        // 表达式分块后，每一块独立计算，所有块的和就是表达式的结果
        long res = 0;
        for (long num : stack) {
            res += num;
        }

        return res;
    }
}
