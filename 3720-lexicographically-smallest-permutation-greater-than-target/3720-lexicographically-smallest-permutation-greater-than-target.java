class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        // Step 1: Match as long a prefix with target as possible
        int matchLen = 0;
        while (matchLen < n && count[target.charAt(matchLen) - 'a'] > 0) {
            count[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }
        // Step 2: Backtrack from matchLen down to 0 to find the latest point we can pick c > target[i]
        for (int i = matchLen; i >= 0; i--) {
            if (i < n) {
                char targetChar = target.charAt(i);
                // Find the smallest available character strictly greater than target[i]
                for (int c = (targetChar - 'a') + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        // Found valid character: construct answer
                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, i);
                        sb.append((char) ('a' + c));
                        count[c]--;
                        // Fill the suffix greedily with smallest available characters
                        for (int j = 0; j < 26; j++) {
                            while (count[j] > 0) {
                                sb.append((char) ('a' + j));
                                count[j]--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }
            // Backtrack: put target.charAt(i - 1) back into the pool
            if (i > 0) {
                count[target.charAt(i - 1) - 'a']++;
            }
        }
        return "";
    }
}