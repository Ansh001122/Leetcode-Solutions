class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*Arrays.sort(nums);

        return nums[nums.length - k];*///  now the twist is that we can't use sorting 

        //so now we will use min-heap

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums){
            heap.offer(num); //add numbers to min-heap

            if(heap.size() > k){
                heap.poll(); //remove number from queue after exceding the size of min heap in comparison to k
            }
        }
        return heap.peek();//now just return the top element
    }
}