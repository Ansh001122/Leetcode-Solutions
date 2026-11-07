class Solution {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        // Store original query indices
        Integer[] order = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            order[i] = i;
        }
        // Sort queries by time
        Arrays.sort(order, (a, b) ->
            Integer.compare(queries[a], queries[b])
        );
        int[] ans = new int[queries.length];
        int[] count = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int idx : order) {
            int q = queries[idx];
            // Add requests up to query time
            while (right < logs.length && logs[right][1] <= q) {
                int server = logs[right][0];
                if (count[server] == 0) {
                    active++;
                }
                count[server]++;
                right++;
            }
            // Remove requests before the window
            while (left < right && logs[left][1] < q - x) {

                int server = logs[left][0];
                count[server]--;
                if (count[server] == 0) {
                    active--;
                }
                left++;
            }
            // Count servers with zero requests
            ans[idx] = n - active;
        }
        return ans;
    }
}