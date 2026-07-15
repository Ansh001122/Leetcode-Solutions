class Solution {
    public int gcdOfOddEvenSums(int n) {
        long sumOdd = 0, sumEven = 0;
        sumOdd = n * n;
        sumEven = n*(n+1);
        return (int)_gcd(sumOdd,sumEven);
    }
    private long _gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}