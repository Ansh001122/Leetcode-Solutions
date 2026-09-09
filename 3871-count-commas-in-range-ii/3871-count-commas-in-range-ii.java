class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        for (long threshold = 1000L; threshold <= n; threshold *= 1000L) {
            totalCommas += (n - threshold + 1);
            if (threshold > Long.MAX_VALUE / 1000L) {
                break;
            }
        }
        return totalCommas;
    }
}