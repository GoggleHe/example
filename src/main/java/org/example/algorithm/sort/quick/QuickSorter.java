package org.example.algorithm.sort.quick;

import java.util.Arrays;

/**
 *
 **/
public class QuickSorter {

    public void sort(int[] arr) {
        int leftBound = 0;
        int rightBound = arr.length - 1;
        partition(arr, leftBound, rightBound);
    }

    private int partition(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return leftBound;
        }
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        System.out.println("pivot = " + pivot);
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, rightBound);

        partition(arr, leftBound, left - 1);
        partition(arr, left, rightBound);
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 5, 6, 7, 32, 32, 21, 1, 3, 4, 5, 6, 2, 3, 4, 2, 52, 35, 23, 3, 3, 35, 3, 2, 35, 3, 3};

        QuickSorter sorter = new QuickSorter();
        sorter.sort(arr);

        System.out.println(Arrays.toString(arr));
    }


}
