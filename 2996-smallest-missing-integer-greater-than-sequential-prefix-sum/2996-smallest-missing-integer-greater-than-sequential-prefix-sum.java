class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {//
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];//Taken from the question itself
            } else {
                break; // Sequential prefix broken
            }
        }
        Set<Integer> set = new HashSet<>();//set for handling the numbers sequence wise 
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(sum)) { //if the set contains the sum then return it otherwise ++ and give the higher after number
            sum++;
        }
        return sum;
    }
}