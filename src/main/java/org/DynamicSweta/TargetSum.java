package org.DynamicSweta;


import java.util.Arrays;

public class TargetSum {

    // Recursive function with memoization
    private static int countWays(int[] nums, int index, int sum, int[][] dp) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) return 2; // +0 and -0 both possible
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }

        if (dp[index][sum] != -1) return dp[index][sum];

        // not take current element
        int notTake = countWays(nums, index - 1, sum, dp);

        // take current element if possible
        int take = 0;
        if (nums[index] <= sum) {
            take = countWays(nums, index - 1, sum - nums[index], dp);
        }

        return dp[index][sum] = take + notTake;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int S = 0;
        for (int num : nums) S += num;

        // Check for invalid cases
        if ((S + target) % 2 != 0 || S < Math.abs(target)) return 0;

        int sum = (S + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countWays(nums, n - 1, sum, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Number of ways = " + findTargetSumWays(nums, target));
    }
}

