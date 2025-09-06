package org.DynamicSweta;
import java.util.Arrays;

public class MinSubsetSumDiff {

    private static boolean subsetSum(int index, int sum, int[] nums, int[][] dp) {
        if (sum == 0) return true;
        if (index == 0) return nums[0] == sum;

        if (dp[index][sum] != -1) return dp[index][sum] == 1;

        boolean notTake = subsetSum(index - 1, sum, nums, dp);
        boolean take = false;
        if (nums[index] <= sum) {
            take = subsetSum(index - 1, sum - nums[index], nums, dp);
        }

        dp[index][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static int minSubsetSumDifference(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        int n = nums.length;
        int[][] dp = new int[n][total + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // fill subset sum dp
        for (int i = 0; i <= total / 2; i++) {
            subsetSum(n - 1, i, nums, dp);
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= total / 2; s1++) {
            if (dp[n - 1][s1] == 1) {
                minDiff = Math.min(minDiff, Math.abs(total - 2 * s1));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        System.out.println("Min subset sum difference = " + minSubsetSumDifference(nums));
    }
}

