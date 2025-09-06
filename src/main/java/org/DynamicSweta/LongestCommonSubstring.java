package org.DynamicSweta;

public class LongestCommonSubstring {
    static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset for substring
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println("Longest Common Substring Length: " + longestCommonSubstring(s1, s2));
    }
}

