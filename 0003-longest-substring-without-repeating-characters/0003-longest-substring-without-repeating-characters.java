class Solution {
    public int lengthOfLongestSubstring(String s) {
       /* Set<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0, maxLen = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;*/

        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}