class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clonearr = arr.clone();
        Arrays.sort(clonearr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int num : clonearr) {
           rankMap.putIfAbsent(num , rankMap.size()+1);
        }
        for (int i = 0; i < arr.length; i++) {
            clonearr[i] = rankMap.get(arr[i]);
        }
        return clonearr;
    }
}