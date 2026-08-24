class Solution {
    public int stoneGameVIII(int[] stones) {
       int n = stones.length;
        
        // Compute prefix sums in-place
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }
        
        // Base case: dp[n - 1] = stones[n - 1]
        int dp = stones[n - 1];
        
        // Iterate backwards from n - 2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, stones[i] - dp);
        }
        
        return dp; 
    }
}