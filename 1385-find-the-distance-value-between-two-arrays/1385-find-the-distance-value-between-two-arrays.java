/*class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;  // Brute-force approach
        for(int i = 0;i < arr1.length;i++){
            boolean valid = true;
            for(int j = 0;j < arr2.length;j++){
                int diff = Math.abs(arr1[i] - arr2[j]);

                if(diff <= d){
                    valid = false;
                    break;
                }
            }
            if(valid){
                count++;
            }
        }
        return count;
    }
}*/

//now using Optimized approach (Sorting + Binary search)

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int x : arr1) {
            int left = 0;
            int right = arr2.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr2[mid] < x - d) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == arr2.length || arr2[left] > x + d) {
                count++;
            }
        }
        return count;
    }
}