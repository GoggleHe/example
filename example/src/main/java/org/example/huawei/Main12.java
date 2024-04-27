package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 信道分配
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();

        int[] N = new int[R + 1];
        for (int i = 0; i <= R; i++) {
            N[i] = sc.nextInt();
        }

        int D = sc.nextInt();

        System.out.println(getResult(R, N, D));
    }

    public static int getResult(int R, int[] N, int D) {
        // 将D值转化为二进制形式，并且为了和N[]的阶位进行对应，这里将D的二进制进行了反转
        int[] subtrahend =
                Arrays.stream(new StringBuilder(Integer.toBinaryString(D)).reverse().toString().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // count记录N能承载几个D
        int count = 0;

        // N中高阶信道的单个信道就能满足D，因此这些高阶信道有几个，即能承载几个D
        for (int i = R; i >= subtrahend.length; i--) {
            // R ~ subtrahend.length 阶的单个信道就能承载一个D，因此这些信道有几个，就能承载几个D
            count += N[i];
        }

        // 0 ~ subtrahend.length - 1 阶的单个信道无法承载一个D，因此这些阶需要组合起来才能承载一个D
        int[] minuend = Arrays.copyOfRange(N, 0, subtrahend.length);

        // 进行二进制减法
        while (binary_sub(minuend, subtrahend)) {
            count++;
        }

        return count;
    }

    /**
     * 二进制减法
     *
     * @param minuend    被减数
     * @param subtrahend 减数
     * @return 被减数是否为正数
     */
    public static boolean binary_sub(int[] minuend, int[] subtrahend) {
        // 进行减法运算逻辑, 从高位开始
        for (int i = minuend.length - 1; i >= 0; i--) {

            if (minuend[i] >= subtrahend[i]) {
                // 如果对应位的信道数足够，则直接相减
                minuend[i] -= subtrahend[i];
            } else {
                // 如果对应位的信道数不足，此时有两种策略，一是向低位借，一是向高位借
                // 具体向哪里借，需要看 minuend 的 [0,i] 低位部分是否能够承载 subtrahend[0, i] 低位部分
                if (calc_bin(Arrays.copyOfRange(minuend, 0, i + 1))
                        < calc_bin(Arrays.copyOfRange(subtrahend, 0, i + 1))) {
                    // 如果minuend 的 [0,i]不能承载，则向高位借，即从j=i+1位开始借
                    int j = i + 1;
                    while (j < minuend.length) {
                        if (minuend[j] > 0) {
                            // 如果高位 j 有信道可借，则借
                            minuend[j] -= 1;
                            return true;
                        } else {
                            // 否则继续向更高位探索
                            j += 1;
                        }
                    }
                    // 如果所有高位都没有富余信道数，则说明减法结果为负数
                    return false;
                } else {
                    // 如果minuend 的 [0,i]可以承载，则向低位借(向低位借，可以避免浪费)
                    // 此时minuend[i]为负数，表示欠债
                    minuend[i] -= subtrahend[i];

                    // 将当前阶位的欠债，转移到前面的低阶位上，注意转移时，欠债x2
                    minuend[i - 1] += minuend[i] << 1;

                    // 转移后，当前阶位的欠债变为0
                    minuend[i] = 0;
                }
            }
        }

        return true;
    }

    public static int calc_bin(int[] bin) {
        int ans = 0;
        for (int i = 0; i < bin.length; i++) {
            ans += bin[i] * (1 << i);
        }
        return ans;
    }
}
