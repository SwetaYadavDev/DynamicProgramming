package org.DynamicSweta;

import java.util.Arrays;

public class CountSubsetSum {

    // recursive function with memoization
    private static int countSubsets(int index, int sum, int[] nums, int[][] dp) {
        if (sum == 0) return 1; // empty subset counts as valid
        if (index == 0) return (nums[0] == sum) ? 1 : 0;

        if (dp[index][sum] != -1) return dp[index][sum];

        // not take current element
        int notTake = countSubsets(index - 1, sum, nums, dp);

        // take current element if possible
        int take = 0;
        if (nums[index] <= sum) {
            take = countSubsets(index - 1, sum - nums[index], nums, dp);
        }

        dp[index][sum] = take + notTake;
        return dp[index][sum];
    }

    public static int countSubsetSumMemo(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countSubsets(n - 1, target, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println("Count of subsets = " + countSubsetSumMemo(nums, target));
    }
}
