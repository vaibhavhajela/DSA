package com.algo.dp;

/**
 * Created by vaibhavhajela on 17/10/20.
 */
public class CoinSumProblem {

        static int findWays(int[] coins, int sum) {
            // Declaring a 2-D array
            // for storing solutions to subproblems:
            int size = coins.length;
            int[][] arr = new int[size + 1][sum + 1];

            // Initializing first column of array to 1
            // because a sum of 0 can be made
            // in one possible way: {0}
            for(int i = 0; i < size + 1; i++)
                arr[i][0] = 1;


            // Applying the recursive solution:
            for(int i = 1; i < size + 1; i++)
                for(int j = 0; j < sum + 1; j++)
                    if(coins[i - 1] > j)
                        arr[i][j] = arr[i - 1][j];
                    else
                        arr[i][j] = arr[i-1][j - coins[i - 1]] + arr[i - 1][j];

            return arr[size][sum];
        }

        public static void main(String args[])
        {
            int coins[] = {1, 2};  // Declaring array of coins
            int sum = 5;  // The sum to be made

            System.out.println("The possible ways in which " + sum
                    + " can be made is " + findWays(coins, sum));
        }
}
