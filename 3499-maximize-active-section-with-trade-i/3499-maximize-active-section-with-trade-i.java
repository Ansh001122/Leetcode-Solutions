class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int maxZeroMerge = 0;
        int prevZeroLen = 0;
        
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            int len = j - i;
            
            if (s.charAt(i) == '1') {
                totalOnes += len;
            } else {
                // If there was a '0' block before the current one (separated by a '1' block),
                // prevZeroLen will be > 0, allowing them to merge.
                if (prevZeroLen > 0) {
                    maxZeroMerge = Math.max(maxZeroMerge, prevZeroLen + len);
                }
                prevZeroLen = len;
            }
            
            i = j;
        }
        
        return totalOnes + maxZeroMerge;
    }
}