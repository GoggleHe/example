package org.example.leetcode.solutions;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//
// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// 你可以按 任意顺序 返回答案 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
//
// Related Topics 数组 双指针 排序
// 👍 1796 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i]
                            + (long) nums[j]
                            + (long) nums[k]
                            + (long) nums[l];

                    if (sum == target) {
                        List<Integer> res = Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        );
                        boolean exist = false;
                        for (int m = 0; m < result.size(); m++) {
                            Object[] integers = result.get(m).toArray();
                            Object[] objects = res.toArray();
                            if (isSame(integers, objects)) {
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            result.add(res);
                        }
                    }
                    if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return result;
    }

    boolean isSame(Object[] nums1, Object[] nums2) {
        if (nums1.length != nums2.length) {
            return false;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            if (!Objects.equals(nums1[i], nums2[i])) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

