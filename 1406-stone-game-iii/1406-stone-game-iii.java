class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i] stores max score diff starting from index i
        
        // Base case: dp[n] = 0 (no stones left)

        for (int i = n - 1; i >= 0; i--) {
            int takeSum = 0;
            int maxDiff = Integer.MIN_VALUE;

            // Try taking 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {
                takeSum += stoneValue[i + k];
                int currentDiff = takeSum - dp[i + k + 1];
                maxDiff = Math.max(maxDiff, currentDiff);
            }

            dp[i] = maxDiff;
        }

        int result = dp[0];
        if (result > 0) return "Alice";
        if (result < 0) return "Bob";
        return "Tie";
    }
}