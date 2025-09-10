package org.DynamicSweta;

import java.util.Arrays;

public class CountSubsetSumMemo {

    // Recursive function with memoization to count subsets
    static int countSubsetsUtil(int index, int sum, int[] arr, int[][] dp) {

        // Base case 1: If sum becomes 0, we found a valid subset → count 1
        if (sum == 0) return 1;

        // Base case 2: If only one element left (index = 0), 
        // check if it equals sum; if yes → count 1, else → count 0
        if (index == 0) return (arr[0] == sum) ? 1 : 0;

        // If result is already calculated, return it to avoid recomputation
        if (dp[index][sum] != -1) return dp[index][sum];

        // Choice 1: Do not include current element
        int notTake = countSubsetsUtil(index - 1, sum, arr, dp);

        // Choice 2: Include current element (if it does not exceed sum)
        int take = 0;
        if (arr[index] <= sum)
            take = countSubsetsUtil(index - 1, sum - arr[index], arr, dp);

        // Store result in dp table and return
        return dp[index][sum] = take + notTake;
    }

    // Main function to initialize dp table and call recursive function
    static int countSubsets(int[] arr, int sum) {
        int n = arr.length;

        // Create dp table with size n x (sum+1), initialized with -1
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Call recursive function starting from last index
        return countSubsetsUtil(n - 1, sum, arr, dp);
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};  // Input array
        int sum = 10;                     // Target sum

        // Print count of subsets with given sum
        System.out.println("Count of subsets with sum " + sum + " = " +
                countSubsets(arr, sum));
    }
}



