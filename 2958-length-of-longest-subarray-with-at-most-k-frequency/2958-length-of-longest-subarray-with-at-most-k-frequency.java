class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap<>();//map for storing frequencies
        int result = 0, i = 0, j = 0, n = nums.length;
        
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);//put in map the frequencies till j<n
            
            while (map.get(nums[j]) > k && i < j) {//1st condition for shrinking the window size 
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;//then again adding the element to the window
            }
            
            result = Math.max(result, j - i + 1);//2nd condition normal way to finding the current window size in sliding window
            j++;//getting the final window
        }
        
        return result;
    }
}