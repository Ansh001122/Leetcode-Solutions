class Solution {
    public long gcdSum(int[] nums) {
       int max = -1,n = nums.length;
       int[] prefixGcd = new int[n];

       for(int i = 0; i < n;i++){
        max = Math.max(nums[i],max);
        prefixGcd[i] = (int) gcd(nums[i],max);
       }
       long ans = 0;
       Arrays.sort(prefixGcd);
       for(int i = 0,j = n-1;i<j;i++,j--){
        ans += gcd(prefixGcd[i] , prefixGcd[j]); 
       }
       return ans;
    }
    public long gcd(long a, long b){
        if(b == 0)
            return a;
        return gcd(b , a%b);
    }
}