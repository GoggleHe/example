package org.example.algorithm.sort.heap;

import java.util.Arrays;

/**
 *
 **/
public class HeapSorter {

    public void sort(int[] arr) {
        buildMaxHeap(arr);

        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private void heapify(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
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
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    private void swap(int[] arr, int i, int largest) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 4, 5, 6};

        HeapSorter sorter = new HeapSorter();
        sorter.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
