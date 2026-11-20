class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
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
        return maxLen;
    }
}