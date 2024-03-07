package org.example.algorithm.sort.heap;

import java.util.Arrays;

/**
 *
 **/
public class HeapSorter {

    public void sort(int[] arr) {
        //构建大根堆，堆顶是最大的元素
        buildMaxHeap(arr);

        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            //将堆顶最大的元素和数组最后一个元素交换
            swap(arr, 0, i);
            //固定最后一个元素，不参与堆结构
            length--;
            //重新堆化
            heapify(arr, 0, length);
        }
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public void heapify(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        System.out.println("heapify->i = " + i);
        System.out.println("heapify->left = " + left);
        System.out.println("heapify->right = " + right);
        while (left < length) {
            if (arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < length && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(arr, i, largest);
            } else {
                break;
            }
            System.out.println("heapify->largest = " + largest);
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int i, int largest) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        // int[] arr = {9, 2, 3, 4, 5, 6};
        int[] arr = {2,4,3,5,1};

        HeapSorter sorter = new HeapSorter();
        // sorter.sort(arr);
        sorter.heapify(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

}
