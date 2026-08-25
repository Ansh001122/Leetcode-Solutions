class Solution {
    public int missingMultiple(int[] nums, int k) {
        /*Set<Integer> hash = new HashSet<>();
        for(int num : nums){
            hash.add(num);
        }
        int res = k;
        while(hash.contains(res)){
            res += k;
        }
        return res;  Hashing Problem*/

        boolean[] arr = new boolean[102];
        for (int num : nums) {
            if (num <= 100) {
                arr[num] = true;
            }
        }
        int res = k;
        while (res <= 100 && arr[res]) {
            res += k;
        }
        return res;
    }
}