class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            char sChar = sArr[i];
            for (int j = m; j >= 1; j--) {
                if (sChar == tArr[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m];
    }
}