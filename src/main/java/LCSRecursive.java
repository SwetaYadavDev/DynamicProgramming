
public class LCSRecursive {
    static int lcsRecursive(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + lcsRecursive(s1, s2, i - 1, j - 1);
        else
            return Math.max(lcsRecursive(s1, s2, i - 1, j), lcsRecursive(s1, s2, i, j - 1));
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        System.out.println("LCS Length: " + lcsRecursive(s1, s2, s1.length() - 1, s2.length() - 1));
    }
}

