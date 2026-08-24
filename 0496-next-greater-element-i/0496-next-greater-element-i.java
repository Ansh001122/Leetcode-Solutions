class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       /* Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return result;*/

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];
        
        Arrays.fill(res, -1);
        for (int i = 0; i < n1; i++) {
            int target = nums1[i];
            int j = 0;
            
            while (j < n2 && nums2[j] != target) {
                j++;
            }
            for (int k = j + 1; k < n2; k++) {
                if (nums2[k] > target) {
                    res[i] = nums2[k];
                    break;
                }
            }
        }
        return res;
    }
}