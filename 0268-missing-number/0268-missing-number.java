class Solution {
    public int missingNumber(int[] nums) {
        int ALLXOR = nums.length;
        for(int i = 0; i<nums.length;i++){
            ALLXOR = ALLXOR ^ i;   
        }
        for(int num : nums){
            ALLXOR = ALLXOR ^ num;
        }        
        return ALLXOR;
    }
}