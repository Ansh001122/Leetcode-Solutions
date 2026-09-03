class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};//As we need to return in 1- Based index format 
            } else if (sum < target) {
                left++; 
            } else {
                right--; 
            }
        }
        return new int[]{-1, -1}; //If nothing found blank but the answer should be -1, -1 (No null returning)
    }
}