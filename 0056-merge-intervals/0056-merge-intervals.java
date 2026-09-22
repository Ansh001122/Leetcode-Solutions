class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Step 2: Sort intervals based on their starting values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new LinkedList<>();

        // Step 3: Iterate through intervals and merge overlapping ones
        for (int[] interval : intervals) {
            // If the list of merged intervals is empty or the current interval 
            // does not overlap with the previous one, simply add it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Otherwise, there is an overlap, so merge them by updating 
                // the end time of the previous interval to be the max of both ends.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        // Step 4: Convert the List back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}