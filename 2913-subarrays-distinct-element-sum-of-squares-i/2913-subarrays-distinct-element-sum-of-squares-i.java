class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;

        for(int i = 0;i < nums.size();i++){
            Set<Integer> set = new HashSet<>(); // we have to create a set after the first loop so that it won't store out the the set retains old elements, leading to incorrect
            for(int j = i;j < nums.size();j++){
                set.add(nums.get(j)); // as the type is collections so we have to use nums.get() so that it can fetch from the loop and store it in set.
                ans += set.size() * set.size();
            }
        }
        return ans;
    }
}