package org.example.leetcode.solutions;//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。
//
// 假定每组输入只存在恰好一个解。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,0], target = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 1000
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104
//
// Related Topics 数组 双指针 排序
// 👍 1548 👎 0


import java.util.Arrays;

//org.example.leetcode submit region begin(Prohibit modification and deletion)
class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        int distance = Math.abs(target - closest);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i - 1 > 0) {
                if (nums[i - 1] == nums[i]) {
                    continue;
                }
            }

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum) {
                    return target;
                }
                int dis = Math.abs(target - sum);
                if (dis < distance) {
                    distance = dis;
                    closest = sum;
                }
                if (sum < target) {
                    int j0 = j + 1;
                    while (j0 < k && nums[j] == nums[j0]) {
                        j0++;
                    }
                    j = j0;
                } else {
                    int k0 = k - 1;
                    while (k0 > j && nums[k] == nums[k0]) {
                        k0--;
                    }
                    k = k0;
                }
            }
        }
        return closest;
    }



}
//org.example.leetcode submit region end(Prohibit modification and deletion)
