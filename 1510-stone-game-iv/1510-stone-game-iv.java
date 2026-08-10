class Solution {
    public boolean winnerSquareGame(int n) {
      /* if (n == 0) return false;

        boolean[] dp = new boolean[n + 1];

        // PART 2: Pre-mark perfect squares as winning moves
        for (int k = 1; k * k <= n; k++) dp[k * k] = true;

        // PART 3: Compute remaining states
        for (int i = 1; i <= n; i++) {
            for (int k = 1; !dp[i] && k * k <= i; k++) {
                dp[i] = !dp[i - k * k];
            }
        }

        return dp[n];*/


        if (n == 0) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];

        // PART 2: Set exact square numbers to true (instant win in 1 move)
        for (int k = 1; k * k <= n; k++) {
            dp[k * k] = true;
        }

        // PART 3: Main loop for remaining states
        for (int i = 1; i <= n; i++) {
            // If i is already marked true as a square number, skip checking
            if (dp[i]) {
                continue;
            }

            // Check if any valid move leaves opponent in a losing (false) state
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }    
}