class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
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
        return (resultzero == 0) ? n-1 : n;
    }
}