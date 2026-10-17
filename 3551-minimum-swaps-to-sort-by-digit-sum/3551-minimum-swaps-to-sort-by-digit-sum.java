class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Step 1: Create a sorted copy of nums based on the custom sorting rule
        Integer[] sortedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[i];
        }
        
        Arrays.sort(sortedNums, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        
        // Step 2: Map each value to its correct target index
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numToIndex.put(sortedNums[i], i);
        }
        
        // Step 3: Count permutation cycles using visited tracking
        boolean[] visited = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            // Traverse the cycle starting from index i
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = numToIndex.get(nums[j]);
            }
            cycles++;
        }
        
        // Step 4: Minimum swaps = total elements - number of cycles
        return n - cycles;
    }
    
    // Helper method to compute the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}