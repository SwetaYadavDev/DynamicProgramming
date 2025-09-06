package org.DynamicSweta;
import java.util.Arrays;

public class RodCuttingMemo {

    public static int cutRod(int[] price, int n, int len, int[][] dp) {
        // Base case: only one length available → take as many as possible
        if (n == 0) {
            return len * price[0]; // cut into all 1-length pieces
        }

        if (dp[n][len] != -1) return dp[n][len];

        // Not take the current length
        int notTake = cutRod(price, n - 1, len, dp);

        // Take the current length (if possible)
        int take = Integer.MIN_VALUE;
        int rodLength = n + 1;
        if (rodLength <= len) {
            take = price[n] + cutRod(price, n, len - rodLength, dp);
        }

        return dp[n][len] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int N = 8;
        int[][] dp = new int[N][N + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Maximum price = " + cutRod(price, N - 1, N, dp));
    }
}

