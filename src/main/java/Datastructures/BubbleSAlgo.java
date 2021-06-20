package Datastructures;

public class BubbleSAlgo {

    public void bubbleSort(int[] array){

        for (int i=0; i < array.length-1; i++) {            // n * C1
            //Iteration
            for (int j = 0; j < array.length - i; j++) {    // n * n * C2
                if (array[j] > array[j + 1]) {              // n * n * C3
                    swap(array, j, j + 1);               // n * n  * C4
                }
            }
        }
    }
    // = nC1 + n^2(C5) =>  n^2 = O(n^2)

    private void swap(int[] array, int p, int q){
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

}
