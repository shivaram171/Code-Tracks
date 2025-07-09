// LeetCode Problem: 1. Two Sum
// Language: Java
// Date: 2024-03-11 
// Link: https://leetcode.com/problems/two-sum/description/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[0];
    }
}
