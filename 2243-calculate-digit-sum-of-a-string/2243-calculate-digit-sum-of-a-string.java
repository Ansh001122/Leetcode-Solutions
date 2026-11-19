class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            
            // Process the string in chunks of size k
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                int end = Math.min(i + k, s.length());
                
                // Sum the digits in the current group
                for (int j = i; j < end; j++) {
                    sum += s.charAt(j) - '0';
                }
                
                // Append the sum of the group to our new builder
                sb.append(sum);
            }
            
            // Update s for the next round
            s = sb.toString();
        }
        
        return s;
    }
}