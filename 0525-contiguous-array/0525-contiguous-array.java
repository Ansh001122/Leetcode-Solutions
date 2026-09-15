class Solution {
    public int findMaxLength(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0)  nums[i] = -1;
        }
        int sum = 0;
        int max_length = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                int last = map.get(sum);
                max_length = Math.max(max_length ,i - last);
            }
            else{
                map.put(sum , i);
            }
        }
        return max_length;
    }
}