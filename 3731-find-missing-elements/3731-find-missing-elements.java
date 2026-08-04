class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // Step 1: Track existing elements and find min / max boundaries
        Set<Integer> present = new HashSet<>();
        for (int num : nums) {
            present.add(num);
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }

        // Step 2: Collect missing numbers in sorted order
        List<Integer> result = new ArrayList<>();
        for (int i = minVal; i <= maxVal; i++) {
            if (!present.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}