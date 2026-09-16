class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int maxN = n + k;
        
        // Build Pascal's Triangle to compute combinations modulo 10^9 + 7
        long[][] C = new long[maxN + 1][maxN + 1];
        
        for (int i = 0; i <= maxN; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        
        // The answer is C(n + k - 1, 2k)
        return (int) C[n + k - 1][2 * k];
    }
}