package org.DynamicSweta;

import java.util.Arrays;

public class EqualSumPartition {

    private static boolean isSubsetSum(int index, int sum, int[] nums, int[][] dp) {
        if (sum == 0) return true;
        if (index == 0) return nums[0] == sum;

        if (dp[index][sum] != -1) return dp[index][sum] == 1;

        // not take the element
        boolean notTake = isSubsetSum(index - 1, sum, nums, dp);

        // take the element if possible
        boolean take = false;
        if (nums[index] <= sum) {
            take = isSubsetSum(index - 1, sum - nums[index], nums, dp);
        }

        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;  // odd sum can't be partitioned
        int target = total / 2;

        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return isSubsetSum(n - 1, target, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Equal partition possible? " + canPartition(nums));
    }
}

