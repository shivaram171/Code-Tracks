class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // 1 - wall, 2 - guard, 3 - guarded
        
        for (int[] w : walls) grid[w[0]][w[1]] = 1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;
        
        // Sweep rows
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            // Left to right
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) seen = false; // wall stops vision
                else if (grid[i][j] == 2) seen = true; // guard found
                else if (seen) grid[i][j] = 3; // mark as guarded
            }
            seen = false;
            // Right to left
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) seen = false;
                else if (grid[i][j] == 2) seen = true;
                else if (seen) grid[i][j] = 3;
            }
        }
        
        // Sweep columns
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            // Top to bottom
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) seen = false;
                else if (grid[i][j] == 2) seen = true;
                else if (seen) grid[i][j] = 3;
            }
            seen = false;
            // Bottom to top
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 1) seen = false;
                else if (grid[i][j] == 2) seen = true;
                else if (seen) grid[i][j] = 3;
            }
        }
        
        // Count unguarded & unoccupied
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) unguarded++;
            }
        }
        
        return unguarded;
    }
}
