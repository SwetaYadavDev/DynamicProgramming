package org.DynamicSweta;
import java.util.Arrays;

public class LongestRepeatingSubsequence {
    private int[][] dp;

    // Recursive helper with memoization
    private int lrsHelper(String s, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        // If characters match and indexes are not same
        if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
            dp[i][j] = 1 + lrsHelper(s, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(lrsHelper(s, i - 1, j), lrsHelper(s, i, j - 1));
        }
        return dp[i][j];
    }

    // Main function to call helper
    public int LongestRepeatingSubsequence(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lrsHelper(s, n, n);
    }

    // Main method to test the program
    public static void main(String[] args) {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        String s = "aabb";
        int result = lrs.LongestRepeatingSubsequence(s);
        System.out.println("Length of Longest Repeating Subsequence: " + result);
    }
}

