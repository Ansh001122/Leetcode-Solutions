class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        /*int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        // Step 1: Enumerate all possible starting indices
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Step 2: Enumerate ending indices to form subarrays nums[i...j]
            for (int j = i; j < n; j++) {
                currentSum += nums.get(j);
                int length = j - i + 1;
                // Step 3: Check length and positive sum constraints
                if (length >= l && length <= r && currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }
        // Return -1 if no valid subarray was found, otherwise return the minimum sum
        return minSum == Integer.MAX_VALUE ? -1 : minSum;

        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        // Check every possible starting index
        for (int i = 0; i < n; i++) {
        int currentSum = 0;
        // Extend the subarray from index i to j
           for (int j = i; j < n; j++) {
              currentSum += nums.get(j);
              int length = j - i + 1;
              // Check if the subarray meets the conditions
              if (length >= l && length <= r && currentSum > 0) {
                 minSum = Math.min(minSum, currentSum);
              }
            }
        }
        // Return -1 if no valid subarray exists
        return minSum == Integer.MAX_VALUE ? -1 : minSum;*/

        int result = Integer.MAX_VALUE;
        int n = nums.size();
        // Try every possible window size k from l to r
        for (int k = l; k <= r; k++) {
            int sum = 0;
            // Calculate the first window of size k
            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                result = Math.min(result, sum);
            }
            // Slide the window across the rest of the array in O(1) per step
            for (int high = k; high < n; high++) {
                sum = sum - nums.get(high - k) + nums.get(high);
                if (sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}