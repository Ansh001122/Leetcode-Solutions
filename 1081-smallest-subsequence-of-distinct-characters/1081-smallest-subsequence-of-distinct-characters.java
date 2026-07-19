class Solution {
    public String smallestSubsequence(String s) {
       boolean visited[] = new boolean[26];
        int li[] = new int[26];
        
        // Fast, non-synchronized stack replacement
        ArrayDeque<Character> st = new ArrayDeque<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            li[s.charAt(i) - 'a'] = i;
        }
        
        // Converted your while loop into a cleaner for-loop
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            
            if (visited[ch - 'a']) {
                continue; // Automatically increments 'r' due to the for-loop
            }
            
            while (!st.isEmpty() && st.peek() > ch && li[st.peek() - 'a'] > r) {
                visited[st.pop() - 'a'] = false;
            }
            
            visited[ch - 'a'] = true;
            st.push(ch);
        }
        
        // Fast, non-synchronized string builder
        StringBuilder sb = new StringBuilder(); 
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}