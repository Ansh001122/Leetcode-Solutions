class Solution {
    public int[] validSequence(String word1, String word2) {
       int n = word1.length();
        int m = word2.length();
        
        // last[j] stores the maximum index i in word1 such that
        // word2[j...m-1] can be matched as a suffix starting from word1[i...]
        int[] last = new int[m];
        Arrays.fill(last, -1);
        
        int i = n - 1;
        int j = m - 1;
        
        // Right-to-left scan to fill the last[] array
        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }
        
        int[] ans = new int[m];
        boolean usedMismatch = false;
        j = 0;
        
        // Left-to-right scan to build the lexicographically smallest sequence
        for (i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } else if (!usedMismatch) {
                // Check if skipping/replacing this character allows us 
                // to complete the rest of word2 using the suffixes precomputed in last[]
                if (j == m - 1 || i < last[j + 1]) {
                    usedMismatch = true;
                    ans[j] = i;
                    j++;
                }
            }
        }
        
        return j == m ? ans : new int[0]; 
    }
}