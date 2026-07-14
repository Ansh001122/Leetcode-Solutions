class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26]; 
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--; // just like we do for a number like '0' so for char we use'a'
            count[t.charAt(i) - 'a']++; 
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}