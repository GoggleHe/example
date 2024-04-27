package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 结队编程
 */
public class Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] levels = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(n, levels));
    }

    static class Node {
        int idx; // 当前节点的值在原数组中的索引
        int val; // 当前节点的值
        Node left; // 当前节点的左子节点
        Node right; // 当前节点的右子节点
        int count; // 当前节点的左子树中节点数量

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    /**
     * 向二叉搜索树中插入新节点
     *
     * @param root （树/子树）根节点
     * @param node 要插入的新节点
     * @param res  数组，其中res[i]代表第i个节点右边比自己小的元素的个数
     * @return 根节点
     */
    public static Node insertNode(Node root, Node node, int[] res) {
        if (root == null) {
            return node;
        }

        // 由于本题中每个员工有独一无二的职级，即levels中所有元素值都不互相相同，因此这里非大即小
        if (node.val < root.val) {
            // 如果要插入的新节点的值，比根节点小，则插入根节点左子树
            root.count++; // 根节点左子树的节点树+1
            root.left = insertNode(root.left, node, res); // 递归进入左子树继续比较
        } else {
            // 如果要插入的新节点的值，比根节点大，则需要插入根节点的右子树
            res[node.idx] += root.count + 1; // 本处代码原理请看题目解析中的图示
            root.right = insertNode(root.right, node, res); // 递归进入右子树继续比较
        }

        return root;
    }

    public static long getResult(int n, int[] levels) {
        Node root = null;

        // rightSmaller[i] 记录的是 levels[i] 右边比自己小的元素的个数
        int[] rightSmaller = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            root = insertNode(root, new Node(i, levels[i]), rightSmaller);
        }

        reverse(levels);
        root = null;

        // leftSmaller[i] 记录的是 levels[i] 左边比自己小的元素的个数
        int[] leftSmaller = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            root = insertNode(root, new Node(i, levels[i]), leftSmaller);
        }
        reverse(leftSmaller);

        // 统计各个元素： 左小 * 右大 + 左大 * 右小
        long sum = 0;
        for (int i = 0; i < n; i++) {
            // 由于本题中每个员工有独一无二的职级，即levels中所有元素值都不互相相同
            long leftSmallerCount = leftSmaller[i];
            // 索引i的左边有 i 个元素，而索引i的左边有leftSmallerCount个比自己小的，因此剩余 i - leftSmallerCount 都是比自己大的
            long leftBiggerCount = i - leftSmallerCount;

            long rightSmallerCount = rightSmaller[i];
            // 索引i右边有 n-i-1 个元素，而索引i的右边有rightSmallerCount比自己小的，因此剩余 n-i-1-rightSmallerCount 都是比自己大的
            long rightBiggerCount = n - i - 1 - rightSmallerCount;

            sum += leftSmallerCount * rightBiggerCount + leftBiggerCount * rightSmallerCount;
        }

        return sum;
    }

    public static void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
