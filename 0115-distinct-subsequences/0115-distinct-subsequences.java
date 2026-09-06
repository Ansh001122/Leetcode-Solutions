class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // If s is shorter than t, it cannot form t as a subsequence
        if (n < m) {
            return 0;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // dp[j] represents the number of ways to form t[0..j-1]
        // Using double or long can handle intermediate counts, but LeetCode guarantees
        // the final answer fits in a 32-bit signed integer.
        int[] dp = new int[m + 1];

        // Base case: 1 way to form the empty string t
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            char sChar = sArr[i];
            // Traverse backward to use values from the previous iteration of s
            for (int j = m; j >= 1; j--) {
                if (sChar == tArr[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m];
    }
}