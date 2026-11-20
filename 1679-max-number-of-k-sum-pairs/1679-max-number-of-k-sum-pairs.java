class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
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
        return operations;
    }
}