class Solution {
    public int minimizeSum(int[] nums) {
        /*int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        // Candidate 1: drop two largest elements -> active window [0 .. n - 3]
        int dropTwoLargest = (nums[n - 3] - nums[0]) + (nums[n - 3] - nums[1]);

        // Candidate 2: drop two smallest elements -> active window [2 .. n - 1]
        int dropTwoSmallest = (nums[n - 1] - nums[2]) + (nums[n - 2] - nums[2]);

        // Candidate 3: drop one smallest and one largest -> active window [1 .. n - 2]
        int dropBothEnds = (nums[n - 2] - nums[1]) + (nums[n - 2] - nums[1]);

        return Math.min(dropTwoLargest, Math.min(dropTwoSmallest, dropBothEnds));*/

        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        Arrays.sort(nums);

        int option1 = nums[n - 3] - nums[0]; // drop two largest
        int option2 = nums[n - 1] - nums[2]; // drop two smallest
        int option3 = nums[n - 2] - nums[1]; // drop one smallest, one largest

        return Math.min(option1,Math.min(option2,option3));
    }
}