package org.DynamicSweta;
import java.util.Arrays;

public class SubsetSum {

    // Recursive function with memoization
    private static boolean isSubsetSum(int index, int sum, int[] nums, int[][] dp) {
        if (sum == 0) return true;   // Found a subset
        if (index == 0) return nums[0] == sum;

        if (dp[index][sum] != -1) return dp[index][sum] == 1;

        // Not take current element
        boolean notTake = isSubsetSum(index - 1, sum, nums, dp);

        // Take current element if possible
        boolean take = false;
        if (nums[index] <= sum) {
            take = isSubsetSum(index - 1, sum - nums[index], nums, dp);
        }

        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static boolean subsetSumMemo(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return isSubsetSum(n - 1, target, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("Subset exists? " + subsetSumMemo(nums, target));
    }
}

