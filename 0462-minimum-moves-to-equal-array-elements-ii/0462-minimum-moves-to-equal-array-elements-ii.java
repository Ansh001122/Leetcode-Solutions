class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        long moves = 0;
        for(int num : nums){
            moves += Math.abs(num - mid);
        }
        return (int)moves;

        /*int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n / 2];
        int moves = 0;
        for (int i = 0; i < n / 2; i++) {
            moves += Math.abs(nums[i] - mid);
            moves += Math.abs(nums[n - i - 1] - mid);
        }
        return moves;*/
    }
}