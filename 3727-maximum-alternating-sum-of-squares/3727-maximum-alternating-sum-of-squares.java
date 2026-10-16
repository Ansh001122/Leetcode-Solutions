class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(squares);
        
        long Score = 0;

        for (int i = 0; i < n/2; i++) {
            Score -= squares[i];
        }
        for (int i = n/2; i < n; i++) {
            Score += squares[i];
        }
        return Score;
    }
}