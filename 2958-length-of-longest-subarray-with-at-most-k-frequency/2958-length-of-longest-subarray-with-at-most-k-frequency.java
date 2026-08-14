class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            count.put(num, count.getOrDefault(num, 0) + 1);

            // Shrink window if current element exceeds allowed frequency k
            while (count.get(num) > k) {
                int leftNum = nums[left];
                count.put(leftNum, count.get(leftNum) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; 
    }
}