class Solution {
    public long[] resultArray(int[] nums, int k) {
       long[] ans = new long[k];
       long[] dp = new long[k]; // dp[r] tracks counts of subarrays ending at current index with remainder r
        
        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;
            
            // 1. Start a fresh subarray consisting only of the current element
            newDp[numMod]++;
            
            // 2. Extend all previous subarrays ending at the prior position
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    int newMod = (int) ((1L * i * numMod) % k);
                    newDp[newMod] += dp[i];
                }
            }
            
            // 3. Accumulate results into the final answer array
            for (int i = 0; i < k; i++) {
                ans[i] += newDp[i];
            }
            
            dp = newDp; // Roll forward to the next index
        }
        
        return ans; 
    }
}