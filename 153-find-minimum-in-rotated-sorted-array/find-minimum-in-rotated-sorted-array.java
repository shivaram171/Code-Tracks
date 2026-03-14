class Solution {
    public int findMin(int[] nums) {

    int max = nums[0];
    for(int i =1;i < nums.length; i++){
                max = Math.min(max, nums[i]);
    }   
    return max;
    }
}