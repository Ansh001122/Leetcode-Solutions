class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int uniqueCount = 0;

        // Iterate through all possible 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int h = num / 100;
            int t = (num / 10) % 10;
            int u = num % 10;

            int[] req = new int[10];
            req[h]++;
            req[t]++;
            req[u]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (req[i] > freq[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}