class Solution {
    public int longestSubsequence(int[] nums) {
        /*int n = nums.length;
        int resultzero = 0;
        boolean allzero = true;

        for(int x : nums){
            resultzero ^= x;
            if(x != 0){
                allzero = false;
            }
        }
        if(allzero){
            return 0;
        }
        return (resultzero == 0) ? n-1 : n; */

        int totalXor = 0;
        boolean hasNonZero = false;

        for (int x : nums) {
            totalXor ^= x;
            if (x != 0) {
                hasNonZero = true;
            }
        }

        // If all elements are 0, no non-zero XOR subsequence can be formed
        if (!hasNonZero) {
            return 0; // or -1 depending on problem requirement
        }

        // If the full XOR sum is already non-zero, take the whole array
        if (totalXor != 0) {
            return nums.length;
        }

        // Otherwise, removing any non-zero element leaves a non-zero XOR sum
        return nums.length - 1;
    }
}