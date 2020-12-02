package org.example.algorithm.sort.merge;

import java.util.Arrays;

/**
 *
 **/
public class MergeSorter {

    public int[] sort(int[] nums) {
        if (nums.length < 3) {
            Arrays.sort(nums);
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int j = 0, k = 0;
        for (int i = 0; i < merge.length; i++) {
            if (j < nums1.length && k < nums2.length) {
                if (nums1[j] <= nums2[k]) {
                    merge[i] = nums1[j];
                    j++;
                } else {
                    merge[i] = nums2[k];
                    k++;
                }
            } else if (j < nums1.length) {
                merge[i] = nums1[j];
                j++;
            } else {
                merge[i] = nums2[k];
                k++;
            }
        }
        return merge;
    }

    public static void main(String[] args) {
        int[] arr = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1};
        MergeSorter sorter = new MergeSorter();
        int[] sort = sorter.sort(arr);
        System.out.println(Arrays.toString(sort));

    }
}
