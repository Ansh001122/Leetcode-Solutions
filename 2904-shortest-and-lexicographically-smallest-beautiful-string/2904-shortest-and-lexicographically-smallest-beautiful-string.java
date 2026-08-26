class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
       int left = 0, count = 0;
        String result = "";
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') count++;
           
            while (count == k) {
                if (s.charAt(left) == '1') {
                    String sub = s.substring(left, right + 1);
                    if (result.isEmpty() || sub.length() < result.length() || 
                       (sub.length() == result.length() && sub.compareTo(result) < 0)) {
                        result = sub;
                    }
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}