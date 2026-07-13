class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String sample = "123456789";
        
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        
        // Explore all possible lengths of sequential digits
        for (int length = minLen; length <= maxLen; length++) {
            // Slide a window of 'length' across the sample string
            for (int start = 0; start <= sample.length() - length; start++) {
                String substring = sample.substring(start, start + length);
                int num = Integer.parseInt(substring);
                
                // If it fits within the range, add it to our list
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}