class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // dp[i][M] stores max stones the player can get starting from index i with parameter M
        int[][] dp = new int[n + 1][n + 1];

        // Precalculate suffix sums (total remaining stones from index i to end)
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Fill DP table backwards (from end of piles to start)
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                // If player can take all remaining piles in one move
                if (i + 2 * M >= n) {
                    dp[i][M] = suffixSum[i];
                } else {
                    // Try taking X piles (1 <= X <= 2 * M)
                    for (int X = 1; X <= 2 * M; X++) {
                        int nextM = Math.max(M, X);
                        int score = suffixSum[i] - dp[i + X][nextM];
                        dp[i][M] = Math.max(dp[i][M], score);
                    }
                }
            }
        }

        // Answer for game starting at index 0 with M = 1
        return dp[0][1];
    }
}