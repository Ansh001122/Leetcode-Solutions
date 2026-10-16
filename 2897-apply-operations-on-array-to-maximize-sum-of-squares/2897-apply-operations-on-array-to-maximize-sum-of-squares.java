class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCount = new int[31]; 
        
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        long totalSumOfSquares = 0;
    
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i < 31; i++) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--;
                }
            }
            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum) % MOD) % MOD;
        }
        return (int) totalSumOfSquares;
    }
}