class Solution {
    public int maxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                long val = nums[j];
                if (prod > 1_000_000_000_000L / val) {
                    break;
                }

                prod *= val;
                g = gcd(g, val);
                l = (l / gcd(l, val)) * val;

                if (prod == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}