package org.DynamicSweta;


public class LCSMemoization {
    static int lcsMemo(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcsMemo(s1, s2, i - 1, j - 1, dp);
        else
            return dp[i][j] = Math.max(lcsMemo(s1, s2, i - 1, j, dp),
                    lcsMemo(s1, s2, i, j - 1, dp));
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++)
            for (int j = 0; j < s2.length(); j++)
                dp[i][j] = -1;

        System.out.println("LCS Length: " + lcsMemo(s1, s2, s1.length() - 1, s2.length() - 1, dp));
    }
}

