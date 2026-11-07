class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {

        // Busy: [finishTime, serverIndex]
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Idle: [weight, serverIndex]
        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Initially all servers are idle
        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[]{servers[i], i});
        }

        long ts = 0;
        int[] ans = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {

            ts = Math.max(ts, i);

            release(busy, idle, servers, ts);

            // Wait if no server is available
            if (idle.isEmpty()) {
                ts = busy.peek()[0];
                release(busy, idle, servers, ts);
            }

            // Select the best available server
            int[] server = idle.poll();

            int idx = server[1];

            ans[i] = idx;

            // Mark server as busy
            busy.offer(new int[]{
                (int)(ts + tasks[i]), idx
            });
        }

        return ans;
    }

    private void release(
        PriorityQueue<int[]> busy,
        PriorityQueue<int[]> idle,
        int[] servers,
        long ts
    ) {

        while (!busy.isEmpty() && busy.peek()[0] <= ts) {

            int[] server = busy.poll();

            int idx = server[1];

            idle.offer(new int[]{servers[idx], idx});
        }
    }
}