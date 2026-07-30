class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;
        
        for (int i = 0; i < n; i++) {
            // i-th letter (0-indexed) gets cost (i/8 + 1)
            totalPushes += (i / 8) + 1;
        }
        
        return totalPushes;
    }
}