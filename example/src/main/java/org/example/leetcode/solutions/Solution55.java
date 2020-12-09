package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution55 {
    //[3,2,1,0,4]
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(nums);
        System.out.println(b);
    }
}
