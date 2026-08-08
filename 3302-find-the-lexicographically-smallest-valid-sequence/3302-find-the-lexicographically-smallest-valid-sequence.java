class Solution {
    public int[] validSequence(String word1, String word2) {
       int n = word1.length(), m = word2.length();
        int[] last = new int[m];
        Arrays.fill(last, -1);
        int j = m - 1;

        // Step 1: Right-to-left pass (Precompute suffix matching)
        for (int i = n - 1; i >= 0; --i) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j -= 1;
            }
        }

        int[] res = new int[m];
        int skip = 0;
        j = 0;

        // Step 2: Left-to-right pass (Greedy Lexicographical Selection)
        for (int i = 0; i < n; ++i) {
            if (j == m) break;
            
            // Match condition OR valid single-mismatch condition
            if (word1.charAt(i) == word2.charAt(j) || (skip == 0 && (j == m - 1 || i < last[j + 1]))) {
                skip += word1.charAt(i) != word2.charAt(j) ? 1 : 0;
                res[j] = i;
                j += 1;
            }
        }

        return j == m ? res : new int[0];
    }
}