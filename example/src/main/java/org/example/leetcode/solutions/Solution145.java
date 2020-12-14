package org.example.leetcode.solutions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {
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

        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                queue
            }
        }*/
        /*Solution145 solution145 = new Solution145();
        List<Integer> integers = solution145.postorderTraversal(node);
        System.out.println(integers);*/

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root, prev = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                res.add(node.val);
                prev = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return res;
    }
}
