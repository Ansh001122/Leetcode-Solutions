class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        // dp.get(val) = max length of a consecutive sequence ending at `val`
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int x : nums) {
            // Option 1: increment x to (x + 1), extending a chain ending at x
            int extendToNext = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, extendToNext);
            maxLen = Math.max(maxLen, extendToNext);

            // Option 2: keep x as x, extending a chain ending at (x - 1)
            int extendToCurr = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, extendToCurr);
            maxLen = Math.max(maxLen, extendToCurr);
        }

        return maxLen;
    }
}