package org.example.algorithm.sort.insert;

import java.util.Arrays;

/**
 *
 **/
public class InsertSorter {

    public void sort(int[] arr) {
        //从下标1开始，将最小的树插入最左侧，原数据整体右移一位
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;
            while (j > 0 && current < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3, 7, 3, 9, 0, 3, 6, 7, 3,};
        InsertSorter sorter = new InsertSorter();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
