class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*Arrays.sort(nums);

        return nums[nums.length - k];*///  now the twist is that we can't use sorting 

        //so now we will use min-heap

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums){
            heap.offer(num);

            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}