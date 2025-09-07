package org.DynamicSweta;

import java.util.*;

public class PalindromeMinCuts {
    public int minCut(String s) {
        int n = s.length();
        // isPal[i][j] = true if substring s[i..j] is palindrome
        boolean[][] isPal = new boolean[n][n];
        // dp[i] = minimum cuts for substring s[0..i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i; // max cuts = i (cut before every character)
            for (int j = 0; j <= i; j++) {
                // If substring s[j..i] is palindrome
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPal[j+1][i-1])) {
                    isPal[j][i] = true;
                    // If palindrome starts from index 0, no cut needed
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        // Else minimize cuts
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n-1]; // minimum cuts for full string
    }

    public static void main(String[] args) {
        PalindromeMinCuts obj = new PalindromeMinCuts();
        String s = "aab";
        // Output: 1 (one cut: "aa" | "b")
        System.out.println(obj.minCut(s));
    }
}
