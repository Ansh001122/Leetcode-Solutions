class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0, i = 0, j = 0, n = nums.length;
        
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            
            result = Math.max(result, j - i + 1);
            j++;
        }
        
        return result;
    }
}