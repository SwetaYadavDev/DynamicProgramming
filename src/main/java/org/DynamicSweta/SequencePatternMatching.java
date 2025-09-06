package org.DynamicSweta;

import java.util.Arrays;

public class SequencePatternMatching {
    private int[][] dp;

    // LCS with memoization
    private int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = 1 + lcs(s1, s2, n-1, m-1);
        } else {
            return dp[n][m] = Math.max(lcs(s1, s2, n-1, m), lcs(s1, s2, n, m-1));
        }
    }

    public boolean isSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int lcsLength = lcs(s1, s2, n, m);
        return lcsLength == n;
    }

    public static void main(String[] args) {
        SequencePatternMatching spm = new SequencePatternMatching();
        String s1 = "abc", s2 = "ahbgdc";
        System.out.println(spm.isSubsequence(s1, s2)); // Output: true
    }
}

