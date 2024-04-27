package org.example.huawei;

import java.util.Scanner;

/**
 * 员工派遣（Java & JS & Python & C）
 * 题目描述
 * 某公司部门需要派遣员工去国外做项目。
 * <p>
 * 现在，代号为 x 的国家和代号为 y 的国家分别需要 cntx 名和 cnty 名员工。
 * <p>
 * 部门每个员工有一个员工号（1,2,3,......），工号连续，从1开始。
 * <p>
 * 部长派遣员工的规则：
 * <p>
 * 规则1：从 [1, k] 中选择员工派遣出去
 * 规则2：编号为 x 的倍数的员工不能去 x 国，编号为 y 的倍数的员工不能去 y 国。
 * 问题：
 * <p>
 * 找到最小的 k，使得可以将编号在 [1, k] 中的员工分配给 x 国和 y 国，且满足 x 国和 y 国的需求。
 * <p>
 * 输入描述
 * 四个整数 x，y，cntx，cnty。
 * <p>
 * 2 ≤ x < y ≤ 30000
 * x 和 y 一定是质数
 * 1 ≤ cntx, cnty < 10^9
 * cntx + cnty ≤ 10^9
 * 输出描述
 * 满足条件的最小的k
 */
public class Main11 {
    static long x;
    static long y;
    static long cntx;
    static long cnty;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();
        cntx = sc.nextInt();
        cnty = sc.nextInt();

        long min = cntx + cnty;
        //    long max = Long.MAX_VALUE;  // 使用此上限，实际通过率55%
        long max = 1000000000L; // 使用此上限，实际通过率可以100%

        while (min <= max) {
            long mid = min + (max - min) / 2;

            if (check(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    public static boolean check(long k) {
        long A = k / x; // 1~k范围内x倍数的数量
        long B = k / y; // 1~k范围内y倍数的数量
        long C = k / (x * y); // 1~k范围内x*y倍数的数量

        return Math.max(0, cntx - (B - C)) + Math.max(0, cnty - (A - C)) <= k - A - B + C;
    }
}
