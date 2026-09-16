class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Math.abs(resultSum - target); // Properly sync with initial resultSum

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return target; // Exact match found
                }
                int diffToTarget = Math.abs(sum - target);
                if (diffToTarget < minDifference) {
                    minDifference = diffToTarget;
                    resultSum = sum;
                }
                // Adjust pointers AFTER evaluation
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resultSum;
    }
}