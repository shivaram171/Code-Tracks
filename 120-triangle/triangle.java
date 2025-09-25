import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> below = triangle.get(i + 1);
            
            for (int j = 0; j < row.size(); j++) {
                int minPath = Math.min(below.get(j), below.get(j + 1));
                row.set(j, row.get(j) + minPath);
            }
        }
        
        return triangle.get(0).get(0); 
    }
}
