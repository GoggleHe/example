package org.example.tmp;

import java.util.ArrayList;
import java.util.List;

public class Test {
//数组M=[1,2,3,4,5,6,15,20,30,40,50,...139...]
//求和=N的组合，不限制组内个数

    public static List<List<Integer>> test(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = nums[i];
            list.add(nums[i]);
            int j = i + 1;
            while (j < nums.length && sum < n) {
                sum += nums[j];
                list.add(nums[j]);
                if (sum == n) {
                    result.add(list);
                }
                j++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 15, 20, 30, 40, 50};
        List<List<Integer>> test = test(nums, 11);
        System.out.println(test);
    }
}
