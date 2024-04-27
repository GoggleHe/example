package org.example.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 简易内存池
 * <p>
 * 题目描述
 * 请实现一个简易内存池,根据请求命令完成内存分配和释放。
 * 内存池支持两种操作命令，REQUEST和RELEASE，其格式为：
 * REQUEST=请求的内存大小 表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址；如果内存不足，或指定的大小为0，则输出error。
 * RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
 * 注意：
 * <p>
 * 内存池总大小为100字节。
 * 内存池地址分配必须是连续内存，并优先从低地址分配。
 * 内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放。
 * 不会释放已申请的内存块的中间地址。
 * 释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
 * 输入描述
 * 首行为整数 N , 表示操作命令的个数，取值范围：0 < N <= 100。
 * <p>
 * 接下来的N行, 每行将给出一个操作命令，操作命令和参数之间用 “=”分割。
 * <p>
 * 输出描述
 * 请求分配指定大小内存时，如果分配成功，返回分配到的内存首地址；如果内存不足，或指定的大小为0，则输出error
 * <p>
 * 释放掉之前分配的内存时，释放成功无需输出，如果释放不存在的首地址则输出error。
 * <p>
 * 用例
 * 输入	2
 * REQUEST=10
 * REQUEST=20
 * 输出	0
 * 10
 * 说明	无
 * 输入	5
 * REQUEST=10
 * REQUEST=20
 * RELEASE=0
 * REQUEST=20
 * REQUEST=10
 * 输出	0
 * 10
 * 30
 * 0
 * 说明
 * 第一条指令，申请地址0~9的10个字节内存，返回首地址0
 * <p>
 * 第二条指令，申请地址10~29的20字节内存，返回首地址10
 * <p>
 * 第三条指令，释放首地址为0的内存申请，0~9地址内存被释放，变为空闲，释放成功，无需输出
 * <p>
 * 第四条指令，申请20字节内存，09地址内存连续空间不足20字节，往后查找到3049地址，返回首地址30
 * <p>
 * 第五条指令，申请10字节，0~9地址内存空间足够，返回首地址0
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
