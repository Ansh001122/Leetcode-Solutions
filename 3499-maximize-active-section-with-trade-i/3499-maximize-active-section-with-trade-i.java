class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        
        // Collect lengths and types of consecutive blocks
        java.util.List<Integer> blockLens = new java.util.ArrayList<>();
        java.util.List<Character> blockTypes = new java.util.ArrayList<>();
        
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;
            blockLens.add(len);
            blockTypes.add(s.charAt(i));
            
            if (s.charAt(i) == '1') {
                totalOnes += len;
            }
            i = j;
        }
        
        int maxTradeGain = 0;
        
        // Find internal '1' blocks surrounded by '0' blocks on both sides
        int numBlocks = blockTypes.size();
        for (int k = 1; k < numBlocks - 1; k++) {
            if (blockTypes.get(k) == '1' && blockTypes.get(k - 1) == '0' && blockTypes.get(k + 1) == '0') {
                int leftZeroLen = blockLens.get(k - 1);
                int rightZeroLen = blockLens.get(k + 1);
                maxTradeGain = Math.max(maxTradeGain, leftZeroLen + rightZeroLen);
            }
        }
        
        return totalOnes + maxTradeGain;
    }
}