package org.example.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 贪心歌手
 * <p>
 * 题目描述
 * 一个歌手准备从A城去B城参加演出。
 * <p>
 * 按照合同，他必须在 T 天内赶到
 * 歌手途经 N 座城市
 * 歌手不能往回走
 * 每两座城市之间需要的天数都可以提前获知。
 * 歌手在每座城市都可以在路边卖唱赚钱。
 * <p>
 * 经过调研，歌手提前获知了每座城市卖唱的收入预期：
 * 如果在一座城市第一天卖唱可以赚M，后续每天的收入会减少D（第二天赚的钱是 M - D，第三天是 M - 2D ...）。如果收入减少到 0 就不会再少了。
 * 歌手到达后的第二天才能开始卖唱。如果今天卖过唱，第二天才能出发。
 * 贪心的歌手最多可以赚多少钱？
 * <p>
 * 输入描述
 * 第一行两个数字 T 和 N，中间用空格隔开。
 * <p>
 * T 代表总天数，0 < T < 1000
 * N 代表路上经过 N 座城市，0 < N < 100
 * 第二行 N+1 个数字，中间用空格隔开。代表每两座城市之间耗费的时间。
 * <p>
 * 其总和 ≤ T。
 * 接下来 N 行，每行两个数字 M 和 D，中间用空格隔开。代表每个城市的输入预期。
 * <p>
 * 0 < M < 1000
 * 0 < D < 100
 * 输出描述
 * 一个数字。代表歌手最多可以赚多少钱。以回车结束。
 */
public class Main6 {
    static int t;
    static int n;
    static int roadCost;
    static int[][] mds;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        n = sc.nextInt();

        // roadCost是A~B城市必需的路程时间
        roadCost = 0;
        for (int i = 0; i < n + 1; i++) {
            roadCost += sc.nextInt();
        }

        mds = new int[n][2];
        for (int i = 0; i < n; i++) {
            mds[i][0] = sc.nextInt();
            mds[i][1] = sc.nextInt();
        }

        System.out.println(getResult());
    }

    public static int getResult() {
        // remain是刨去必要的路程时间后，剩余可以用于赚钱的时间
        int remain = t - roadCost;

        // 如果没有剩余时间可以用，则赚不到钱
        if (remain <= 0) {
            return 0;
        }

        // 优先队列（小顶堆）记录赚到的钱, 即堆顶是某天赚的最少的钱
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for (int[] md : mds) {
            // 第一天卖唱可以赚m，后续每天的收入会减少d
            int m = md[0];
            int d = md[1];

            // 只要在当前城市还有钱赚，那么就继续待
            while (m > 0) {
                // 只有remain天可以赚钱，超出的时间不能赚钱，因此需要比较超出的时间赚的钱m，和前面时间中赚的最少的钱pq.peek
                if (pq.size() >= remain) {
                    // pq.peek只可能是某座城市停留的最后一天的赚的钱，因为每座城市都是停留的最后一天赚的钱最少
                    if (m > pq.peek()) {
                        // 如果当前城市当天赚的钱m，比前面天里面赚的最少的pq.peek多，那么就赚pq.peek钱的那天时间节约下来，给当天用
                        pq.poll();
                    } else {
                        // 如果当前城市当天赚的钱m，比前面天里面赚的最少的pq.peek还少，则当前城市继续待下去赚的钱只会更少，因此没必要呆下去了
                        break;
                    }
                }

                // 如果所有城市停留时间没有超出remain天，或者当天是超出的时间，但是比前面赚的最少的一天的赚的更多，则赚m更优
                pq.add(m);

                //  每天收入减少d
                m -= d;
            }
        }

        return pq.stream().reduce(Integer::sum).orElse(0);
    }
}
