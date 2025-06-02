package org.example.Week_5;

import java.util.Arrays;

public class SortingArrays {

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
    }


    public static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};

        // Bubble Sort
        int[] bubble = Arrays.copyOf(data, data.length);
        bubbleSort(bubble);
        printArray("Bubble Sort:    ", bubble);
    }
}
