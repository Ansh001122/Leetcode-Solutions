class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, ans = 0;
        String str = Integer.toString(n);
        for(int i = 0;i<str.length();i++){
            int digit = str.charAt(i) -'0';
            if(digit != 0){
                sum += digit;
                ans = ans*10 + digit;
            }
        }
        return ans * sum;
    }
}