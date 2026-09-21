class Solution {
    public long[] resultArray(int[] nums, int k) {
       long[] ans = new long[k];
        // dp[r] := the number of subarrays ending at current position with product % k == r
        long[] dp = new long[k];
        
        for (final int num : nums) {
            long[] newDp = new long[k];
            final int numMod = num % k;
            
            // 1. Start a new subarray with only `num`.
            newDp[numMod] = 1;
            
            // 2. Extend all previous subarrays.
            for (int i = 0; i < k; ++i) {
                final int newMod = (int) (1L * i * numMod % k);
                newDp[newMod] += dp[i];
            }
            
            // 3. Accumulate counts into the final answer array.
            for (int i = 0; i < k; ++i) {
                ans[i] += newDp[i];
            }
            
            // 4. Roll over state for the next iteration.
            dp = newDp;
        }
        
        return ans;
    }
}