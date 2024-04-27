package org.example.huawei;

import java.util.Scanner;

/**
 * 路口最短时间问题
 */
public class Main17 {
    static int n;
    static int m;
    static int[][] lights;
    static int timePreRoad;
    static int rowStart;
    static int colStart;
    static int rowEnd;
    static int colEnd;

    static boolean[][] visited;
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lights[i][j] = sc.nextInt();
            }
        }

        timePreRoad = sc.nextInt();

        rowStart = sc.nextInt();
        colStart = sc.nextInt();

        rowEnd = sc.nextInt();
        colEnd = sc.nextInt();

        System.out.println(getResult());
    }

    public static int getResult() {
        // 记录访问过的点，防止走回路
        visited = new boolean[n][m];
        // 初始时起点位置标记为访问过
        visited[rowStart][colStart] = true;

        // 记录起点到终点的最小花费时间，这里minCost定义为数组，是为了其在dfs函数调用结束后，不会被释放内存，因为它是引用类型变量
        int[] minCost = {Integer.MAX_VALUE};
        // 开始暴搜所有起点到终点的路径
        dfs(rowStart, colStart, -1, -1, 0, minCost);
        return minCost[0];
    }

    /**
     * 暴力搜索
     *
     * @param curX    当前位置横坐标
     * @param curY    当前位置纵坐标
     * @param preX    上一个位置横坐标
     * @param preY    上一个位置纵坐标
     * @param cost    到达当前位置花费的时间
     * @param minCost 记录起点到终点的最小花费时间
     */
    public static void dfs(int curX, int curY, int preX, int preY, int cost, int[] minCost) {
        // 如果到达当前前花费的时间cost 达到了 已知minCost，那么后续路径就没必要探索了，因为必然要比minCost大
        if (cost >= minCost[0]) {
            return;
        }

        // 如果当前点是终点，且花费的时间cost更少，则更新minCost
        if (curX == rowEnd && curY == colEnd) {
            minCost[0] = cost;
            return;
        }

        // 否则，从当前位置的四个方向继续探索路径
        for (int[] offset : offsets) {
            // 新位置
            int nextX = curX + offset[0];
            int nextY = curY + offset[1];

            // 新位置越界或者已经访问过，则不能访问，继续其他方向探索
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY]) continue;

            // 标记新位置访问过
            visited[nextX][nextY] = true;

            // 根据pre,cur,next三点，判断拐弯方向
            int direction = getDirection(preX, preY, curX, curY, nextX, nextY);

            // cur到达next位置必须要增加timePreRoad个时间
            int increment = timePreRoad;
            // preX=-1, preY=-1 表示pre位置不存在，此时探索下一个位置不需要花费等待周期
            if (preX >= 0 && preY >= 0 && direction >= 0) {
                // pre位置存在，且cur->next是左拐或者直行，则需要增加当前位置对应的等待周期时间
                increment += lights[curX][curY];
            }

            // 递归进入新位置
            dfs(nextX, nextY, curX, curY, cost + increment, minCost);

            // 回溯
            visited[nextX][nextY] = false;
        }
    }

    /**
     * 根据三点坐标，确定拐弯方向
     *
     * @param preX  前一个点横坐标
     * @param preY  前一个点纵坐标
     * @param curX  当前点横坐标
     * @param curY  当前点纵坐标
     * @param nextX 下一个点横坐标
     * @param nextY 下一个点纵坐标
     * @return cur到next的拐弯方向， >0 表示向左拐， ==0 表示直行（含调头）， <0 表示向右拐
     */
    public static int getDirection(int preX, int preY, int curX, int curY, int nextX, int nextY) {
        // 向量 pre->cur
        int dx1 = curX - preX;
        int dy1 = curY - preY;

        // 向量 cur->next
        int dx2 = nextX - curX;
        int dy2 = nextY - curY;

        // 两个向量的叉积 >0 表示向左拐， ==0 表示直行（含调头）， <0 表示向右拐
        return dx1 * dy2 - dx2 * dy1;
    }
}
