public class QuickSortAlgo {

    public int partition( int[] array, int l , int h){
        int pivot = array[l];
        int i = l + 1;
        int j = h;

        while (i < j ){
            while (array[i] < array[pivot]) i++;
            while (array[j] > array[pivot]) j++;
            if (i > j){
                swap(array,i,j);
            }
        }
        swap(array,j, pivot);
        return j;
    }

    private void swap(int[] arr,int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public void quicksort(int array[], int l, int h){
        if ( l <h){
            int partitionId = partition(array,l,h);
            quicksort(array,l,partitionId);
            quicksort(array, partitionId+1, h);
        }

    }
}


