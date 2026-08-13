class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break; // Sequential prefix broken
            }
        }

        // Step 2: Store all nums elements in a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Find the smallest integer >= sum that is missing from nums
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}