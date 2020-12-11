package org.example.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 **/
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                if (nums[i - 1] == nums[i]) {
                    continue;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - 1 >= 0) {
                    if (nums[j - 1] == nums[j]) {
                        System.out.println(nums[j - 1] + " == " + nums[j]);
                        continue;
                    }
                    for (int k = j + 1; k < nums.length; k++) {
                        if (k - 1 >= 0) {
                            if (nums[k - 1] == nums[k]) {
                                continue;
                            }
                        }
                        System.out.println(nums[i] + "+" + nums[j] + "+" + nums[k]);
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> item = new ArrayList<>();
                            item.add(nums[i]);
                            item.add(nums[j]);
                            item.add(nums[k]);
                            res.add(item);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists);
    }
}
