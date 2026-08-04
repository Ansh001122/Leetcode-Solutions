class Solution {
    public List<Integer> findMissingElements(int[] nums) {
     /* ArrayList<Integer> ans = new ArrayList<>();
      Arrays.sort(nums);
      int n = nums.length;
      int prev = nums[0];
      for(int i = 1;i < n;i++){
        while(nums[i]!= prev+1){
            ans.add(++prev);
        }
        prev = nums[i];
      }
      return ans;*/


      HashSet<Integer> set = new HashSet<>();

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;

      for(int x : nums){
        set.add(x);
        min = Math.min(min , x);
        max = Math.max(max , x);
      }
      List<Integer> ans = new ArrayList<>();

      for(int i = min; i <= max;i++){
        if(!set.contains(i)){
            ans.add(i);
        }
      }
      return ans;
    }
}