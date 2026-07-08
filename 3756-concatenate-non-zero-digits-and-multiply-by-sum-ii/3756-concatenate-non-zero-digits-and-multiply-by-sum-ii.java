class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int MOD = 1_000_000_007;

        long[] concat = new long[n];
        long[] prefix = new long[n];
        int[] nonZero = new int[n];
        long[] pow10 = new long[n];

        pow10[0] = 1;
        for (int i = 1; i < n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long sum = 0;
        long val = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                val = (val * 10 + d) % MOD;
                sum += d;
                cnt++;
            }
            prefix[i] = sum;
            concat[i] = val;
            nonZero[i] = cnt;
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long temp1, temp2;
            if (l != 0) {
                int count = nonZero[r] - nonZero[l - 1];
                
                temp1 = (concat[r] - (concat[l - 1] * pow10[count]) % MOD + MOD) % MOD;
                temp2 = (prefix[r] - prefix[l - 1]) % MOD;
            } else {
                temp1 = concat[r];
                temp2 = prefix[r];
            }
            res[i] = (int) ((temp1 * temp2) % MOD);
        }
        return res;
    }
}