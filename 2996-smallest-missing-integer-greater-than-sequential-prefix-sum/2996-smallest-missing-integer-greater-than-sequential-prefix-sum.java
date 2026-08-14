class Solution {
    public int missingInteger(int[] nums) {
        boolean hash[] = new boolean[51];
        
        for(int i = 0;i < nums.length;i++){
            hash[nums[i]] = true;
        }
        int sum = nums[0];
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] + 1 == nums[i + 1]){
                sum += nums[i+1];
            }
            else {
                break;
            }
        }
        while(sum <= 50 && hash[sum]){
            sum++;
        }
        return sum;
    }
}