class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
       int[] groupId = new int[n];
       int currentGroup = 0;
       groupId[0] = currentGroup;
       for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentGroup++;
            }
            groupId[i] = currentGroup;
        }
        int q = queries.length;
        boolean[] result = new boolean[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            result[i] = (groupId[u] == groupId[v]);
        }
        return result; 
    }
}