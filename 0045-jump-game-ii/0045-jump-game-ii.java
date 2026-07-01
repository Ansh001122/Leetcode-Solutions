class Solution {
    public int jump(int[] nums) {
        int Destination = nums.length - 1; 
        int TotalJumps = 0;
        int LastJumpIndex = 0;
        int farthest = 0;
        for(int i = 0;i < Destination;i++){
            farthest = Math.max(farthest , i + nums[i]);
            if(i == LastJumpIndex){
                TotalJumps++;
                LastJumpIndex = farthest;
                
            }
            if(LastJumpIndex >= Destination){
                return TotalJumps;
            }
        }
        return TotalJumps;
    }
}