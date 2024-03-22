package org.example.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<BinaryTree> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(BinaryTree::getData)
                ); // 题目说：当左右节点权值相同时，左子树高度小于等于右子树高度。因此当节点权重相同时，再按照节点子树高度升序

        for (int i = 0; i < n; i++) {
            // 创建n个哈夫曼树节点
            int w = sc.nextInt();
            BinaryTree node = new BinaryTree(w);
            // 加入优先队列
            pq.offer(node);
        }

        // 初始n个节点经过多轮合并，只剩一个节点时，那么该节点就是哈夫曼树的根节点，因此当优先队列中只剩一个节点时即可停止合并
        while (pq.size() > 1) {
            // 取出优先队列中前两个权值最小的节点，由于优先队列已按照 [节点权重，节点子树高度] 升序优先级，因此先出来的肯定是权重小，或者高度小的节点，即作为新节点的左子树
            BinaryTree lc = pq.poll();
            BinaryTree rc = pq.poll();


            // 将合并后的新节点加入优先队列
            assert rc != null;
            BinaryTree fa = new BinaryTree(lc, rc, lc.getData() + rc.getData());

            pq.offer(fa);


        }
// 最后优先队列中必然只剩一个节点，即哈夫曼树的根节点，此时对此根节点（哈夫曼树）进行中序遍历
        BinaryTree root = pq.poll();
        StringJoiner sj = new StringJoiner(" ");
        midOrder(root, sj);
        String s = JSON.toJSONString(root);
        System.out.println(s);
        System.out.println(sj);
    }

    private static void midOrder(BinaryTree root, StringJoiner sj) {
        // 中序遍历，即先遍历二叉树的左子树，再遍历二叉树的根，最后遍历二叉树的右子树
        if (root.getLeft() != null) {
            midOrder(root.getLeft(), sj);
        }

        sj.add(root.getData() + "");

        if (root.getRight() != null) {
            midOrder(root.getRight(), sj);
        }
    }
}
