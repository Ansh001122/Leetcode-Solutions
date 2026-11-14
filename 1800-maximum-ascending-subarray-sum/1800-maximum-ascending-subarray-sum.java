class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];  //Kadane Algo....
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // If current element is greater than the previous, continue the ascending subarray
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                // Otherwise, reset the running sum to the current element
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}