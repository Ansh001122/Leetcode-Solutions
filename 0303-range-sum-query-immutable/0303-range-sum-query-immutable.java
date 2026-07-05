class NumArray {
    int[] PrefixSums;

    public NumArray(int[] nums) {
        int sumQuery = 0;
        for(int i = 0;i<nums.length;i++){

            nums[i] +=sumQuery;
            sumQuery = nums[i];
        }
        PrefixSums = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return PrefixSums[right];
        }
        else{
            return PrefixSums[right] - PrefixSums[left - 1];
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */