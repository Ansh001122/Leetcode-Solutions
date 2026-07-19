class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (taken[ch - 'a']){
                continue;
            } 
            
            while (!result.isEmpty() && result.charAt(result.length() -1) > ch && 
            lastIndex[result.charAt(result.length() -1) - 'a'] > i) {

                taken[result.charAt(result.length() -1) -'a'] = false;
                result.deleteCharAt(result.length() -1);
            }
            result.append(ch);
            taken[ch -'a'] = true;
        }
        return result.toString();
    }
}