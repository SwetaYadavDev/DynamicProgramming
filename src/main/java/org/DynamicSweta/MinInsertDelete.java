package org.DynamicSweta;

public class MinInsertDelete {

    // Function to find LCS length
    public static int lcsLength(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Function to find min insertions & deletions
    public static void minInsertDelete(String A, String B) {
        int lcs = lcsLength(A, B);
        int deletions = A.length() - lcs;
        int insertions = B.length() - lcs;

        System.out.println("Minimum Deletions: " + deletions);
        System.out.println("Minimum Insertions: " + insertions);
    }

    public static void main(String[] args) {
        String A = "heap";
        String B = "pea";
        minInsertDelete(A, B);
    }
}
