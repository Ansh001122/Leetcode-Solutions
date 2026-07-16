class Solution {
    public long gcdSum(int[] nums) {
       int max = 0,n = nums.length;
       int[] prefixGcd = new int[n];

       for(int i = 0; i < n;i++){
          max = Math.max(nums[i],max);
          prefixGcd[i] = (int) gcd(nums[i],max);
       }
       Arrays.sort(prefixGcd);
       long ans = 0;
       for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}