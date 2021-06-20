package Datastructures;

public class BubbleSortAlgo {

    public void bubblesort(int[] toBeSortedArray) {

        for (int i = 0; i < toBeSortedArray.length; i++) {        //n
            for (int j = 0; j < toBeSortedArray.length - i; j++) { //n * n
                if (toBeSortedArray[j] > toBeSortedArray[j + 1]) {//n* n
                    swap(toBeSortedArray, j, j + 1); //n*n
                }
            }
        }
    }
//n O(n^2)
    private void swap(int[] arr,int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}
