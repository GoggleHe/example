package org.example.leetcode.solutions;


import java.util.LinkedList;
import java.util.Queue;


public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(p);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (node1.left != null) {
                queue1.offer(node1.left);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
            }
            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (node2.right != null) {
                queue2.offer(node2.right);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11))
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)),
                        new TreeNode(7,
                                new TreeNode(14),
                                new TreeNode(15))));
        Solution100 solution100 = new Solution100();
        boolean sameTree = solution100.isSameTree(node, node);
        System.out.println(sameTree);
    }

}
