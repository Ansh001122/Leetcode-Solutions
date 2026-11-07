class Solution {

    static class BusyServer {
        long finishTime;
        int weight;
        int index;

        BusyServer(long finishTime, int weight, int index) {
            this.finishTime = finishTime;
            this.weight = weight;
            this.index = index;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        // Available servers: weight, then index
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: finishTime, weight, then index
        PriorityQueue<BusyServer> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a.finishTime != b.finishTime) {
                    return Long.compare(a.finishTime, b.finishTime);
                }
                if (a.weight != b.weight) {
                    return Integer.compare(a.weight, b.weight);
                }
                return Integer.compare(a.index, b.index);
            }
        );

        // Initially, all servers are available
        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[tasks.length];

        long time = 0;

        for (int i = 0; i < tasks.length; i++) {

            // Current task arrives at time i
            time = Math.max(time, i);

            // Release servers that have completed their tasks
            while (!busy.isEmpty() &&
                   busy.peek().finishTime <= time) {

                BusyServer s = busy.poll();

                available.offer(new int[]{s.weight, s.index});
            }

            // If no server is available, wait
            if (available.isEmpty()) {

                time = busy.peek().finishTime;

                // Release all servers free at this time
                while (!busy.isEmpty() &&
                       busy.peek().finishTime <= time) {

                    BusyServer s = busy.poll();

                    available.offer(new int[]{s.weight, s.index});
                }
            }

            // Select the best available server
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            // Calculate when this server finishes
            long finishTime = time + tasks[i];

            busy.offer(new BusyServer(
                finishTime, weight, index
            ));
        }

        return ans;
    }
}