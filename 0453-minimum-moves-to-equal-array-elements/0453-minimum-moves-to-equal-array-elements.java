class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int num : nums){
            min = Math.min(num,min); //find the minimum element
        }
        int moves = 0;
        for (int num : nums) {
            moves += num - min; //add the moves till it becomes like the min element
        }
        return moves;
    }
}