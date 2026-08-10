class Solution {
    public boolean winnerSquareGame(int n) {
       if (n == 0) return false;

        boolean[] dp = new boolean[n + 1];

        // PART 2: Pre-mark perfect squares as winning moves
        for (int k = 1; k * k <= n; k++) dp[k * k] = true;

        // PART 3: Compute remaining states
        for (int i = 1; i <= n; i++) {
            for (int k = 1; !dp[i] && k * k <= i; k++) {
                dp[i] = !dp[i - k * k];
            }
        }

        return dp[n];
    }    
}