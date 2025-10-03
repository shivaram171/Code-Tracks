import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Traverse
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlap -> merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap -> new interval
                current = interval;
                merged.add(current);
            }
        }

        // Step 3: Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
