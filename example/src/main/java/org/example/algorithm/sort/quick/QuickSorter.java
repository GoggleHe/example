package org.example.algorithm.sort.quick;

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
        //取数组最后一个元素为中心值
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            //指针从左往右，找到第一个大于最右元素的下标
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            //指针从右往左，找到第一个小于最右元素的下标
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            //交换找到的值的位置
            if (left < right) {
                swap(arr, left, right);
            }
            //循环该步骤，实现数组左边小于最右元素，右边大于最右元素
        }
        //交换最右元素和左边分区最后一个left索引的位置，保证最右元素在中心值索引上
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
}
