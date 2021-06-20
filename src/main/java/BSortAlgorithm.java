public class BSortAlgorithm {

    public static void BSort(int[] arr){

        for ( int i=0 ; i < arr.length -1; i++){        //nC1
            for (int j=0; j< arr.length - i; j++){      //n^2C2
                if ( arr[j] > arr [j+1]){               //n^2C3
                    swap(arr,j,j+1);                   //n^2C4
                }
            }
        }
    }
//  n^2 => O(n^2)

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//    T(n)
//    MergeSort(A, l, r):
//        if l> r
//        return
//        m = (l+r)/2
//        mergeSort(A, l, m)           T(n/2)
//        mergeSort(A, m+1, r)         T(n/2)
//        merge(A, l, m, r)             C(n)

// T(n) => T(n/2) + T(n/2) + Cn => 2 T(n/2) + Cn
// 2(2T(n/4) + c(n/2)) + cn => 4T(n/4) + 2 Cn
// > 2^k(n/2^k) + kCn = >
