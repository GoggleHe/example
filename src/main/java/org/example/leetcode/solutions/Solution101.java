package org.example.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 **/
public class Solution101 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(5),
                        new TreeNode(5)),
                new TreeNode(2));
        Solution101 solution101 = new Solution101();
        boolean symmetric = solution101.isSymmetric(treeNode);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            if (queue.size() % 2 != 0) {
                return false;
            }
            List<TreeNode> list = new ArrayList<>();
            TreeNode poll = queue.poll();
            if (poll != null) {
                list.add(poll);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(j);
                if (left == null ^ right == null) {
                    return false;
                } else if (left == null) {
                    return false;
                } else if(left.val != right.val){
                    return false;
                }
            }

        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
    }
}
