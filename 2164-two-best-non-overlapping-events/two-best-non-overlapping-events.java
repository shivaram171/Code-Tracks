class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort events by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Suffix max array for event values
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            int nextIndex = findNext(events, events[i][1]);

            if (nextIndex != -1) {
                value += suffixMax[nextIndex];
            }

            ans = Math.max(ans, value);
        }

        return ans;
    }

    // Binary search to find first event whose start > current end
    private int findNext(int[][] events, int end) {
        int l = 0, r = events.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (events[mid][0] > end) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
