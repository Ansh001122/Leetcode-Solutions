class Solution {
    public int climbStairs(int n, int[] costs) {
       /* int[] dp = new int[n+1];
        dp[0] = 0; //initial phase of cost at step 0
        for(int i = 1;i <= n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1;j <= 3;j++){  // either we can jump 1 or 2 or 3 steps
                if(i - j >= 0){
                    int cost = dp[i-j] + costs[i-1] + j*j;
                    dp[i] = Math.min(dp[i],cost);
                }
            }
        }
        return dp[n];*/


        int[] dp = new int[n + 1];
        // Minimum cost to reach step 0 is 0
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            // Check the previous 1, 2, and 3 steps
            for (int j = Math.max(0, i - 3); j < i; j++) {
                int jump = i - j;
                int totalCost = dp[j] + costs[i - 1] + jump * jump;
                dp[i] = Math.min(dp[i], totalCost);
            }
        }
        return dp[n];
    }
}