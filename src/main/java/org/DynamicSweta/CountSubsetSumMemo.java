package org.DynamicSweta;
import java.util.Arrays;
    public class CountSubsetSumMemo {

        static int countSubsetsUtil(int index, int sum, int[] arr, int[][] dp) {
            // Base cases
            if (sum == 0) return 1;
            if (index == 0) return (arr[0] == sum) ? 1 : 0;

            if (dp[index][sum] != -1) return dp[index][sum];

            // Exclude current element
            int notTake = countSubsetsUtil(index - 1, sum, arr, dp);

            // Include current element (if possible)
            int take = 0;
            if (arr[index] <= sum)
                take = countSubsetsUtil(index - 1, sum - arr[index], arr, dp);

            return dp[index][sum] = take + notTake;
        }

        static int countSubsets(int[] arr, int sum) {
            int n = arr.length;
            int[][] dp = new int[n][sum + 1];
            for (int[] row : dp) Arrays.fill(row, -1);

            return countSubsetsUtil(n - 1, sum, arr, dp);
        }

        public static void main(String[] args) {
            int[] arr = {2, 3, 5, 6, 8, 10};
            int sum = 10;

            System.out.println("Count of subsets with sum " + sum + " = " +
                    countSubsets(arr, sum));
        }
    }


