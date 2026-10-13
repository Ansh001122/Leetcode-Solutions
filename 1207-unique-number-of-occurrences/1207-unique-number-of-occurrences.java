class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a HashSet to check for duplicate frequencies
        Set<Integer> freqSet = new HashSet<>();
        for (int freq : countMap.values()) {
            // If the set already contains this frequency, it's not unique
            if (!freqSet.add(freq)) {
                return false;
            }
        }
        
        return true;
    }
}