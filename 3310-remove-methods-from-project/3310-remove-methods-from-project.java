class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
       List<List<Integer>> edges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] inv : invocations) {
            edges.get(inv[0]).add(inv[1]);
            inDegree[inv[1]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] suspicious = new boolean[n];
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : edges.get(u)) {
                inDegree[v]--;
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    queue.offer(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                // Return all nodes from 0 to n-1 if removal is unsafe
                List<Integer> allNodes = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    allNodes.add(j);
                }
                return allNodes;
            }
        }
      
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                remaining.add(i);
            }
        }
        return remaining;
    }
}