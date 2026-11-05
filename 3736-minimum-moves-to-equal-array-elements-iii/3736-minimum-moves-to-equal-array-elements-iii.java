class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        long ans = 0;
        for (int num : nums) {
            ans += (long) max - num;
        }
        return (int)ans;
    }
}