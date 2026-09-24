class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(digitsum(nums[i]) == i){
                return i;
            }
        }
        return -1;
    }
    private int digitsum(int nums){
        int sum = 0;
        while (nums > 0) {
            sum += nums % 10;
            nums /= 10;
        }
        return sum;
    }

}