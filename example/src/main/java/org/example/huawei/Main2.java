package org.example.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 精准核酸检测
 * <p>
 * 题目描述
 * 为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 * <p>
 * 现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹交叉。
 * <p>
 * 现在给定一组确诊人员编号（X1,X2,X3,...,Xn），在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的人数。（注意：确诊病例自身不需要再做核酸检测）
 * <p>
 * 需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
 * <p>
 * 例如：A是确诊病例，A和B有接触、B和C有接触、C和D有接触、D和E有接触，那么B\C\D\E都是需要进行核酸检测的人。
 * <p>
 * 输入描述
 * 第一行为总人数 N
 * <p>
 * 第二行为确认病例人员编号（确诊病例人员数量 < N），用逗号分割
 * <p>
 * 第三行开始，为一个 N * N 的矩阵，表示每个人员之间是否有接触，0表示没有接触，1表示有接触。
 * <p>
 * 输出描述
 * 整数：需要做核酸检测的人数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] confirmed = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(getResult(n, confirmed, matrix));
    }

    public static int getResult(int n, int[] confirmed, int[][] matrix) {
        UnionFindSet ufs = new UnionFindSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i][j] == 1) {
                    // 有过接触的人进行合并
                    ufs.union(i, j);
                }
            }
        }

        // 统计每个接触群体（连通分量）中的人数
        int[] cnts = new int[n];
        for (int i = 0; i < n; i++) {
            int fa = ufs.find(i);
            cnts[fa]++;
        }

        // 记录已统计过的感染群体
        HashSet<Integer> confirmed_fa = new HashSet<>();

        // 将有感染者的接触群体的人数统计出来
        int ans = 0;
        for (int i : confirmed) {
            int fa = ufs.find(i);

            // 如果该感染群体已统计过，则不再统计
            if (confirmed_fa.contains(fa)) continue;
            confirmed_fa.add(fa);

            ans += cnts[fa];
        }

        // 最终需要做核酸的人数，不包括已感染的人
        return ans - confirmed.length;
    }
}

class UnionFindSet {
    private int[] parent;

    public UnionFindSet(int length) {
        parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[x] = rootY;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

