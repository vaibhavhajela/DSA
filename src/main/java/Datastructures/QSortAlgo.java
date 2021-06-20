package Datastructures;

public class QSortAlgo {

    public int partition ( int[] array, int l, int h){
        //select pivot
        int p = array[l];
        //select i pointer
        int i = l+1;
        //select j pointer
        int j = h;
        //find swap index for i
        while( i<j) {
            while (array[i] < p) i++;
            //find swap index for j
            while (array[j] > p) j--;
            if (i < j) {
                swap(array, i, j);
            }
        }
        if ( i > j){
            swap (array, p, j);
        }
        return j;
    }
    public void quicksort(int[] array, int l, int h){
        if (l<h){
            int partitionId = partition(array,l,h);
            //recursive call for leftsubarray
            quicksort(array,l,partitionId);
            //recursive call for righsubarray
            quicksort(array,partitionId+1,h);
        }
    }

    private void swap(int[] array, int p, int q){
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
}
