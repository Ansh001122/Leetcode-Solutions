class Solution {
    public int totalNumbers(int[] digits) {
       HashSet<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {           // Hundreds place
            for (int j = 0; j < n; j++) {       // Tens place
                for (int k = 0; k < n; k++) {   // Units place
                    if (i != j && i != k && j != k) {
                        if (digits[i] != 0 && digits[k] % 2 == 0) {
                            int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                            uniqueNumbers.add(number);
                        }
                    }
                }
            }
        }
        return uniqueNumbers.size();
    }
}