package org.DynamicSweta;

import java.util.Arrays;

public class CoinChangeWaysMemo {

    public static int countWays(int[] coins, int n, int sum, int[][] dp) {
        // Base cases
        if (sum == 0) return 1;      // one valid way
        if (n == 0) return 0;        // no coins left

        if (dp[n][sum] != -1) return dp[n][sum];

        // Not take the coin
        int notTake = countWays(coins, n - 1, sum, dp);

        // Take the coin (if possible)
        int take = 0;
        if (coins[n - 1] <= sum) {
            take = countWays(coins, n, sum - coins[n - 1], dp);
        }

        return dp[n][sum] = take + notTake;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Number of ways = " + countWays(coins, n, sum, dp));
    }
}