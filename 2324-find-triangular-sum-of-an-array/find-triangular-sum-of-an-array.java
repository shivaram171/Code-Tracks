class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        // Reduce array until only one element left
        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        
        return nums[0];
    }
}
