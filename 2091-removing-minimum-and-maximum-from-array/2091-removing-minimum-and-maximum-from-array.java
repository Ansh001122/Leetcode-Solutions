class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        // Set i to the smaller index and j to the larger index
        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Strategy 1: Remove both from the front
        int frontOnly = j + 1;

        // Strategy 2: Remove both from the back
        int backOnly = n - i;

        // Strategy 3: Remove i from front, j from back
        int bothSides = (i + 1) + (n - j);

        return Math.min(frontOnly, Math.min(backOnly, bothSides));
    }
}