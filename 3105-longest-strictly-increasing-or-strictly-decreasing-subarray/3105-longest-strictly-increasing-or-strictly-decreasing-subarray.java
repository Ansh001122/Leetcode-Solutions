class Solution {
    public int longestMonotonicSubarray(int[] nums){
        int n = nums.length;
        int res = 1;
        int incr = 1, decr = 1;

        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i - 1]){
                incr++;
                decr = 1;
                res = Math.max(res, incr);
            }else if (nums[i] < nums[i - 1]){
                decr++;
                incr = 1;
                res = Math.max(res, decr);
            }else{
                incr = 1;
                decr = 1;
            }
        }
        return res;


        /*brute-force approach 
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int increasing = 1;
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) {
                increasing++;
                j++;
            }
            int decreasing = 1;
            j = i + 1;
            while (j < n && nums[j] < nums[j - 1]) {
                decreasing++;
                j++;
            }
            result = Math.max(result, Math.max(increasing, decreasing));
        }
        return result;*/
    }
}