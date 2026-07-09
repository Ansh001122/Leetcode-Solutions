class Solution {
     static final long MOD = 1_000_000_007L;
    public int[] sumAndMultiply(String s, int[][] queries) {
       int n = s.length();

        long[] digitSumUpTo = new long[n];
        long[] numberUpTo = new long[n];
        int[] nonZerodigit = new int[n];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        nonZerodigit[0] = (s.charAt(0) != '0') ? 1 : 0;
        for(int i = 1; i < n; i++){
            int digit = s.charAt(i) - '0';
            nonZerodigit[i] = nonZerodigit[i - 1] + ((digit != 0) ? 1 : 0); 
        }

        numberUpTo[0] = s.charAt(0) - '0';
        for(int i = 1; i < n; i++){
            int digit = s.charAt(i) - '0';
            if(digit != 0){
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            } else {
                numberUpTo[i] = numberUpTo[i - 1];
            }
        }

        digitSumUpTo[0] = s.charAt(0) - '0';
        for(int i = 1; i < n; i++){
            int digit = s.charAt(i) - '0';
            digitSumUpTo[i] = digitSumUpTo[i - 1] + digit;
        }

        int q = queries.length;
        int[] ans = new int[q]; 
        
        for(int i = 0; i < q; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            
            long sum = digitSumUpTo[r] - ((l == 0) ? 0 : digitSumUpTo[l - 1]);
            
            long checkbound = (l == 0) ? 0 : numberUpTo[l - 1];
            
            int k = nonZerodigit[r] - ((l == 0) ? 0 : nonZerodigit[l - 1]);
            long x = (numberUpTo[r] - (checkbound * pow10[k] % MOD) + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        } 
        return ans;   
    }
}