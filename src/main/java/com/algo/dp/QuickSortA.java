package com.algo.dp;

public class QuickSortA {

    public int partition(int[] arr, int l, int h){
        int p = l;
        int i = l + 1;
        int j = h;
        while ( i < j) {
            while (arr[i] < arr[p]) i++;
            while (arr[j] > arr[p]) j--;
            if (i < j) {
                //swap(arr, i, j);
            }
        }
        //swap(arr, j, p);
        return j;
    }

    public void quicksort(int[] arr, int l, int h){
        if (l < h) {
            int partitionId = partition(arr, l, h);
            quicksort(arr, l, partitionId);
            quicksort(arr, partitionId + 1, h);
        }
    }
}
