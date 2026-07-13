class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String sample = "123456789";
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        
        for (int length = minLen; length <= maxLen; length++) {
           
            for (int start = 0; start <= sample.length() - length; start++) {
                String substring = sample.substring(start, start + length);
                int num = Integer.parseInt(substring);
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}