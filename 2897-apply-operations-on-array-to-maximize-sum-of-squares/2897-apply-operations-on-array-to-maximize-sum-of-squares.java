class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCount = new int[31]; // Since numbers fit in standard integer ranges up to 10^9 (~30 bits)
        
        // Step 1: Count the frequency of 1-bits at each position across all numbers
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long totalSumOfSquares = 0;
        
        // Step 2: Greedily construct the k largest possible numbers
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i < 31; i++) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--;
                }
            }
            // Add the square of the constructed number modulo MOD
            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSumOfSquares;
    }
}