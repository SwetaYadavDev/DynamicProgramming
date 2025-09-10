package org.DynamicSweta;

import java.util.Arrays;

public class CountSubsetSum {

    // Recursive function with memoization
    // index → current index in the array
    // sum → remaining sum we need to form
    // nums → input array
    // dp → memoization table to store results for overlapping subproblems
    private static int countSubsets(int index, int sum, int[] nums, int[][] dp) {
        // Base case: if sum becomes 0 → empty subset is counted as 1 valid subset
        if (sum == 0) return 1;

        // Base case: if only one element is left (index == 0), 
        // check if it alone can form the required sum
        if (index == 0) return (nums[0] == sum) ? 1 : 0;

        // If the subproblem was already solved → return stored result
        if (dp[index][sum] != -1) return dp[index][sum];

        // Case 1: Do NOT take the current element
        int notTake = countSubsets(index - 1, sum, nums, dp);

        // Case 2: Take the current element if it's ≤ sum
        int take = 0;
        if (nums[index] <= sum) {
            take = countSubsets(index - 1, sum - nums[index], nums, dp);
        }

        // Store the result in dp table to avoid recomputation
        dp[index][sum] = take + notTake;

        return dp[index][sum]; // Return total count of subsets
    }

    // Wrapper function to initialize dp table and call recursive function
    public static int countSubsetSumMemo(int[] nums, int target) {
        int n = nums.length;
        // dp[i][j] → number of subsets from first i elements with sum j
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1); // Initialize with -1 (uncomputed)

        // Call recursive function starting from last index
        return countSubsets(n - 1, target, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        // Output → Count of subsets with sum = target
        System.out.println("Count of subsets = " + countSubsetSumMemo(nums, target));
    }
}
