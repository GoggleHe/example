package org.example.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 生成哈夫曼树
 */
public class Main13 {
    // 哈夫曼树节点
    static class Node {
        Node lchild; // 左孩子节点
        Node rchild; // 右孩子节点
        int weight; // 当前节点的权重
        int height; // 当前节点代表子树的高度

        public Node(Node lc, Node rc, int weight, int height) {
            this.lchild = lc;
            this.rchild = rc;
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 将哈夫曼树节点进行排序，方便后面筛选出权值最小的两个节点
        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                a.weight != b.weight
                                        ? a.weight - b.weight
                                        : a.height - b.height); // 题目说：当左右节点权值相同时，左子树高度小于等于右子树高度。因此当节点权重相同时，再按照节点子树高度升序

        for (int i = 0; i < n; i++) {
            // 创建n个哈夫曼树节点
            int w = sc.nextInt();
            Node node = new Node(null, null, w, 0);
            // 加入优先队列
            pq.offer(node);
        }

        // 初始n个节点经过多轮合并，只剩一个节点时，那么该节点就是哈夫曼树的根节点，因此当优先队列中只剩一个节点时即可停止合并
        while (pq.size() > 1) {
            // 取出优先队列中前两个权值最小的节点，由于优先队列已按照 [节点权重，节点子树高度] 升序优先级，因此先出来的肯定是权重小，或者高度小的节点，即作为新节点的左子树
            Node lc = pq.poll();
            Node rc = pq.poll();

            // 将lc和rc合并，合并后新节点fa的权重，是两个子节点权重之和，fa子树高度 = rc子树高度+1; PS：rc的高度>=lc的高度
            int fa_weight = lc.weight + rc.weight;
            int fa_height = rc.height + 1;

            // 将合并后的新节点加入优先队列
            Node fa = new Node(lc, rc, fa_weight, fa_height);
            pq.offer(fa);
        }

        // 最后优先队列中必然只剩一个节点，即哈夫曼树的根节点，此时对此根节点（哈夫曼树）进行中序遍历
        Node root = pq.poll();
        StringJoiner sj = new StringJoiner(" ");
        midOrder(root, sj);

        System.out.println(sj);
    }

    public static void midOrder(Node root, StringJoiner sj) {
        // 中序遍历，即先遍历二叉树的左子树，再遍历二叉树的根，最后遍历二叉树的右子树
        if (root.lchild != null) {
            midOrder(root.lchild, sj);
        }

        sj.add(root.weight + "");

        if (root.rchild != null) {
            midOrder(root.rchild, sj);
        }
    }
}
