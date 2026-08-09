class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // Compute suffix sums to quickly find total remaining stones
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // Memoization table: memo[i][M]
        int[][] memo = new int[n][n + 1];
        
        return dfs(piles, suffixSum, 0, 1, memo);
    }

    private int dfs(int[] piles, int[] suffixSum, int i, int M, int[][] memo) {
        if (i >= piles.length) return 0;
        
        // Base case: If we can take all remaining piles in one move
        if (i + 2 * M >= piles.length) return suffixSum[i];
        
        // Return cached result if already computed
        if (memo[i][M] != 0) return memo[i][M];
        
        int maxStones = 0;
        
        // Try taking X piles (1 <= X <= 2 * M)
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int opponentStones = dfs(piles, suffixSum, i + X, nextM, memo);
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }
        
        memo[i][M] = maxStones;
        return maxStones;
    }
}