class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2) return nums[0];

        int[] skipfirsthouse = new int[n - 1];
        int[] skiplasthouse = new int[n - 1];

        for(int i = 0;i < n-1;i++){
            skipfirsthouse[i] = nums[i]; 
            skiplasthouse[i] = nums[i + 1];
        }    

        int lootfirst = helpRob(skipfirsthouse);
        int lootlast = helpRob(skiplasthouse);

        return Math.max(lootfirst , lootlast);
    }
    public int helpRob(int[] nums){
        int n = nums.length;
        if (n < 2) return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + nums[i]);
        }
        return dp[n - 1];
    }            
}