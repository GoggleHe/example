package org.example.huawei;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 执行任务赚积分（Java & JS & Python & C）
 * 题目描述
 * 现有N个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为1。
 * <p>
 * 每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
 * <p>
 * 可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
 * <p>
 * 输入描述
 * 第一行为一个数 N，表示有 N 个任务
 * <p>
 * 1 ≤ N ≤ 100
 * 第二行为一个数 T，表示可用于处理任务的时间
 * <p>
 * 1 ≤ T ≤ 100
 * 接下来 N 行，每行两个空格分隔的整数（SLA 和 V），SLA 表示任务的最晚处理时间，V 表示任务对应的积分。
 * <p>
 * 1 ≤ SLA ≤ 100
 * 0 ≤ V ≤ 100000
 * 输出描述
 * 可获得的最多积分
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //任务数
        int n = sc.nextInt();
        //可用时间
        int t = sc.nextInt();
        //{截止时间,积分}
        int[][] wos = new int[n][2];
        for (int i = 0; i < n; i++) {
            wos[i][0] = sc.nextInt();
            wos[i][1] = sc.nextInt();
        }

        System.out.println(getResult(wos, t));
    }

    public static int getResult(int[][] wos, int t) {
        // 按照任务截止时间升序
        Arrays.sort(wos, (a, b) -> a[0] - b[0]);

        // pq用于按照积分对任务进行优先级排序，积分越小，优先级越高，目的是为了每次替换掉最少积分的工单
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        // 当前时间
        int curTime = 0;
        // 已获得的积分
        int ans = 0;

        // 遍历任务
        for (int[] wo : wos) {
            int endTime = wo[0]; // 任务截止时间
            int score = wo[1]; // 任务积分

            if (curTime < endTime) {
                // 如果 curTime < 当前任务的截止时间，则curTime时刻可以指向当前任务
                pq.offer(score);
                ans += score;
                curTime++;
            } else {
                // 如果 curTime >= 当前任务的截止时间，则当前任务只能在curTime时刻之前找一个时间点执行

                // pq中记录的就是curTime之前时刻执行的任务
                if (pq.size() == 0) {
                    continue;
                }

                // 此时取出pq记录的可执行的任务中最小积分的那个
                int min_score = pq.peek();

                // 如果当前任务的积分 > 前面时间内可执行的任务中最小积分
                if (score > min_score) {
                    // 则我们应该将执行pq中最小积分任务的时间，用于执行当前任务，因为这样可以获得更大积分
                    pq.poll();
                    pq.offer(score);
                    ans += score - min_score;
                }
            }
        }

        // 由于时间限制为t单位，而每个任务花费1单位时间，因此最多完成t个任务，对于多出任务应该去除，且优先去除积分少的
        while (pq.size() > t && t > 0) {
            ans -= pq.poll();
        }

        return ans;
    }
}
