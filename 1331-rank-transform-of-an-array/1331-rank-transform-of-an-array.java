class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clonearr = arr.clone();
        Arrays.sort(clonearr);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : clonearr) {
           
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}