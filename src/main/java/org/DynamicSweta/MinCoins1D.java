package org.DynamicSweta;

import java.util.Arrays;

public class MinCoins1D {

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0; // 0 coins to make amount 0

        for (int coin : coins) {
            for (int sum = coin; sum <= amount; sum++) {
                dp[sum] = Math.min(dp[sum], 1 + dp[sum - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Min coins = " + minCoins(coins, amount));
    }
}
