package com.yay.test;

import java.util.Arrays;

/**
 * 描述:
 * @author yangyang26
 * @version 1.0
 * @since 2019/3/20 20:20
 */
public class SortTest {


    private static int[] array = new int[]{9, 1, 3, 18, 17, 15, 11, 7, 8, 4, 21, 12, 16, 1, 0, 20, 10, 4, 2, 17, 5};


    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }


    private static void chooseSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {


            }
        }

    }

    private static void quickSort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = partition(array, low, high);
        quickSort(array, low, mid - 1);
        quickSort(array, mid + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            //一定先从高到低，不然上来low++就有问题了
            while (key <= array[high] && low < high) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }


    private static int binarySearch(int[] array, int low, int high, int value) {

        if (low > high) {
            return -1;
        }
        //建议用low + (high - low) / 2 而不是 (low + high) / 2
        int mid = low + (high - low) / 2;
        if (array[mid] == value) {
            return mid;
        }

        if (array[mid] < value) {
            return binarySearch(array, mid + 1, high, value);
        }
        if (array[mid] > value) {
            return binarySearch(array, low, mid - 1, value);
        }
        return -1;

    }

    private static int bs(int[] array, int value) {

        return binarySearch(array, 0, array.length, value);
    }


    public static void main(String[] args) {

        //bubbleSort(array);
        quickSort(array, 0, array.length - 1);


        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));


        System.out.println(bs(array, 21));
        System.out.println(array.length);


    }


}
