package org.example.niuke;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 简易内存池
 */
public class Main3 {

    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] cmds = new String[n][2];
        for (int i = 0; i < n; i++) cmds[i] = sc.next().split("=");

        getResult(n, cmds);
    }

    // 算法入口
    public static void getResult(int n, String[][] cmds) {
        // used保存被占用的内存 [起始地址，结束地址]，初始时有一个[100,101]作为尾边界限定
        LinkedList<Integer[]> used = new LinkedList<>();
        used.add(new Integer[]{100, 101});

        for (String[] cmd : cmds) {
            String key = cmd[0];
            String val = cmd[1];

            // 申请内存
            if ("REQUEST".equals(key)) {
                // 当指令为REQUEST时，对应值为要申请的内存的大小，即size
                int size = Integer.parseInt(val);

                // 我们默认从start=0位置开始检查可用内存区间
                int start = 0;
                boolean flag = true;

                for (int i = 0; i < used.size(); i++) {
                    int end = start + size - 1;
                    // 要申请的内存区间
                    Integer[] range = {start, end};

                    // 检查要申请的内存区间和已占有的内存区间是否交叉
                    if (!hasIntersection(used.get(i), range)) {
                        // 若不存在交叉，则将申请区间加入used中
                        used.add(i, range);
                        flag = false;
                        // 并打印此时申请区间的起始位置
                        System.out.println(start);
                        break;
                    } else {
                        // 若存在交叉，则将变更要申请的内存区间的起始位置
                        start = used.get(i)[1] + 1;
                    }
                }

                // 一旦申请到内存，那么flag就会被赋值为false，否则就保持true，意味着每申请到内存，则打印error
                if (flag) System.out.println("error");
            }
            // 释放内存
            else {
                //  当指令为RELEASE时，值为要释放内存的起始地址addr
                int addr = Integer.parseInt(val);
                boolean flag = true;

                for (int i = 0; i < used.size(); i++) {
                    // 到已占有内存中找起始位置是addr的，找到则将该区间从used中删除，表示解除占用
                    if (used.get(i)[0] == addr) {
                        used.remove(i);
                        flag = false;
                        break;
                    }
                }

                // 一旦释放成功，则flag就会被置为false，否则就保持True,意味着没有内存释放，则打印error
                if (flag) System.out.println("error");
            }
        }
    }

    // 判断两个区间是否存在交集
    public static boolean hasIntersection(Integer[] range1, Integer[] range2) {
        int s1 = range1[0];
        int e1 = range1[1];

        int s2 = range2[0];
        int e2 = range2[1];

        if (s1 == s2) return true;
        else if (s1 < s2) return e1 >= s2;
        else return e2 >= s1;
    }
}
