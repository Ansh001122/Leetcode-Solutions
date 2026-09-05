class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // sufMin[i] holds min(nums[i..n-1])
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        int prefMax = nums[0];

        // Linear scan to find the first index satisfying the stability score
        for (int i = 0; i < n; i++) {
            if (nums[i] > prefMax) {
                prefMax = nums[i];
            }

            // Using long avoids overflow if bounds are widened
            if ((long) prefMax - sufMin[i] <= (long) k) {
                return i;
            }
        }

        return -1;
    }
}