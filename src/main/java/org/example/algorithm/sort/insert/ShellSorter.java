package org.example.algorithm.sort.insert;

import java.util.Arrays;

/**
 *
 **/
public class ShellSorter {
    public void sort(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            System.out.println("gap = " + gap);
            for (int i = gap; i < length; i += gap) {
                System.out.println("i = " + i);
                int j = i;
                int current = arr[j];
                while (j > 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1};
        ShellSorter sorter = new ShellSorter();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
