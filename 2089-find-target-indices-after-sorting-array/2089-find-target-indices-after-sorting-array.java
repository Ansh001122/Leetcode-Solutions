class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int lessThan = 0;
        
        // Count frequencies in a single pass
        for (int num : nums) {
            if (num < target) {
                lessThan++;
            } else if (num == target) {
                count++;
            }
        }
        
        // Build the result list with consecutive indices
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(lessThan + i);
        }
        
        return res;
    }
}