package org.DynamicSweta;

public class SCSLength {

    // Function to find LCS length
    public static int lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Function to find SCS length
    public static int scsLength(String X, String Y) {
        int lcs = lcsLength(X, Y);
        return X.length() + Y.length() - lcs;
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int scsLen = scsLength(X, Y);
        System.out.println("Length of Shortest Common Supersequence: " + scsLen);
    }
}

