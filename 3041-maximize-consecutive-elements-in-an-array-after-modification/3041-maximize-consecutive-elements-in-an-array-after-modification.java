class Solution {
    public int maxSelectedElements(int[] nums) {
        /*Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int x : nums) {
            int extendToNext = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, extendToNext);
            maxLen = Math.max(maxLen, extendToNext);

            int extendToCurr = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, extendToCurr);
            maxLen = Math.max(maxLen, extendToCurr);
        }
        return maxLen;*/

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] dp = new int[max + 4]; // +1 offset for 0-values, +2 for (max + 1), +1 buffer
        int best = 0;

        for (int a : nums) {
           int idx = a + 1;
           dp[idx + 1] = Math.max(dp[idx + 1], dp[idx] + 1);
           dp[idx] = Math.max(dp[idx], dp[idx - 1] + 1);
           best = Math.max(best, Math.max(dp[idx], dp[idx + 1]));
        }
        return best;
    }
}