class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hash = new HashSet<>();
        for(int num : nums){
            hash.add(num);
        }
        int res = k;
        while(hash.contains(res)){
            res += k;
        }
        return res;
    }
}