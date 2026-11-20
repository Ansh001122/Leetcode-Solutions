class Solution {
    public int maxOperations(int[] nums, int k) {
        /*Map<Integer, Integer> freq = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;
            int available = freq.getOrDefault(complement, 0);

            if (available > 0) {
                operations++;
                freq.put(complement, available - 1);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }
        return operations;*/

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == k) {
                count++;
                start++;
                end--;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}