package com.algo.dp;

/**
 * Created by vaibhavhajela on 16/10/20.
 */
public class KnapsackUnbounded {

    static int knapsackDP(int[] w, int[] v, int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i][j - w[i - 1]] + v[i - 1]);
                }
                TablePrinter.printArray(m);
            }

        }
        return m[n][W];
    }

    public static void main( String args[]){
        int[] w = {1, 3 , 4 , 5};
        int[] v = {1, 4 , 5, 7 };
        int W = 7;
        int result = knapsackDP(w, v, 4, W);
        System.out.println("result:" + result);

    }
}
