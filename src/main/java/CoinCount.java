/**
 * Created by vaibhavhajela on 10/10/20.
 */
public class CoinCount {


    // Function to find the total number of ways to get change
    // of N from unlimited supply of coins in set S
    public static int count(int[] S, int N)
    {
        // if total is 0, return 1
        if (N == 0) {
            return 1;
        }

        // return 0 if total become negative
        if (N < 0) {
            return 0;
        }

        // initialize total number of ways to 0
        int res = 0;

        // do for each coin
        for (int i = 0; i < S.length; i++)
        {
            // recur to see if total can be reached by including
            // current coin S[i]
            res += count(S, N - S[i]);
        }

        // return total number of ways
        return res;
    }

    public static int count(int[] S, int n, int N)
    {
        // if total is 0, return 1 (solution found)
        if (N == 0) {
            return 1;
        }

        // return 0 (solution do not exist) if total become negative or
        // no elements are left
        if (N < 0 || n < 0) {
            return 0;
        }

        // Case 1. include current coin S[n] in solution and recur
        // with remaining change (N - S[n]) with same number of coins
        int incl = count(S, n, N - S[n]);

        // Case 2. exclude current coin S[n] from solution and recur
        // for remaining coins (n - 1)
        int excl = count(S, n - 1, N);

        // return total ways by including or excluding current coin
        return incl + excl;
    }

    public static void main(String[] args)
    {
        // n coins of given denominations
        int[] S = { 1, 2, 3 };

        // Total Change required
        int N = 4;

        System.out.println("Total number of ways to get desired change is "
                + count(S, N));
    }
}