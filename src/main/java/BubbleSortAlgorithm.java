class BubbleSortAlgorithm{

    public static void bsort(int[] arr, int n){

        for (int i=0; i < n; i++){
            for (int j=1; j< n-i ; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                }
            }
        }
    }


    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}