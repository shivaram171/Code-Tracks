import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // all i..j-1 form valid triangles with j, k
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
