package org.example.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 找城市
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] relations = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        System.out.println(getResult(n, relations));
    }

    public static String getResult(int n, int[][] relations) {
        // 记录最小dpi
        int minDp = Integer.MAX_VALUE;
        // 记录最小dpi对应的切断城市
        ArrayList<Integer> city = new ArrayList<>();

        // i 是被切断城市
        for (int i = 1; i <= n; i++) {
            // 利用并查集对城市进行关联
            UnionFindSet20 ufs = new UnionFindSet20(n + 1);

            for (int[] relation : relations) {
                int x = relation[0];
                int y = relation[1];
                // 如果x或y是被切断城市，则对应连接关系不成立
                if (x == i || y == i) continue;
                // 否则连接x和y
                ufs.union(x, y);
            }

            int[] cnts = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                // 对j=1~n每个城市找根fa
                int fa = ufs.find(j);
                // 根fa下的子城市个数++
                cnts[fa]++;
            }

            // cnts的最大值即最大城市群大小
            int dp = Arrays.stream(cnts).max().orElse(0);

            // 和minDp比较，保留最小值
            if (dp < minDp) {
                minDp = dp;
                city = new ArrayList<>();
                city.add(i);
            } else if (dp == minDp) {
                city.add(i);
            }
        }

        // 如果有多个，按照编号升序输出。
        city.sort((a, b) -> a - b);
        StringJoiner sj = new StringJoiner(" ");
        for (Integer c : city) {
            sj.add(c + "");
        }
        return sj.toString();
    }
}

// 并查集实现
class UnionFindSet20 {
    int[] fa;

    public UnionFindSet20(int n) {
        this.fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
    }

    public int find(int x) {
        if (this.fa[x] != x) {
            return this.fa[x] = this.find(this.fa[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int x_fa = this.find(x);
        int y_fa = this.find(y);

        if (x_fa != y_fa) {
            this.fa[y_fa] = x_fa;
        }
    }
}
