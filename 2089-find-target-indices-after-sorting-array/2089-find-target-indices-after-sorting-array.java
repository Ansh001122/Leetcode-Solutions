class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
       /* int count = 0;
        int lessThan = 0;

        for (int num : nums) {
            if (num < target) {
                lessThan++;
            } else if (num == target) {
                count++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(lessThan + i);
        }
        return res;*/


        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;  
    }
}