class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // sufMin[i] stores the minimum element in nums[i..n-1]
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        int prefMax = Integer.MIN_VALUE;

        // Find the smallest stable index
        for (int i = 0; i < n; i++) {
            prefMax = Math.max(prefMax, nums[i]);
            
            // Instability score: max(nums[0..i]) - min(nums[i..n-1])
            if (prefMax - sufMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}