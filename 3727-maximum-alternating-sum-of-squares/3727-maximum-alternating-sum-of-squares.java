class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        // Step 1: Compute squares of all elements
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        // Step 2: Sort the squares in ascending order
        Arrays.sort(squares);
        
        long totalScore = 0;
        int negativeCount = n / 2; // Number of elements to subtract
        
        // Step 3: Subtract the smallest squares
        for (int i = 0; i < negativeCount; i++) {
            totalScore -= squares[i];
        }
        
        // Step 4: Add the remaining larger squares
        for (int i = negativeCount; i < n; i++) {
            totalScore += squares[i];
        }
        
        return totalScore;
    }
}