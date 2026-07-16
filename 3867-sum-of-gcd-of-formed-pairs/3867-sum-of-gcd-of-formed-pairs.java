class Solution {
    public long gcdSum(int[] nums) {
       int max = 0,n = nums.length;
       int[] arr = new int[n];

       for(int i = 0; i < n;i++){
          max = Math.max(nums[i],max);
          arr[i] = (int) gcd(nums[i],max);
       }
       Arrays.sort(arr);
       long totalSum = 0;
       int left = 0;
       int right = n - 1;
       while (left < right) {
            totalSum += gcd(arr[left++], arr[right--]);
       }
       return totalSum;
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