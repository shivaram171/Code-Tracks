class Solution {
    public int findGCD(int[] nums) {
        
            int min = nums[0];
            int max = nums[0];

            for(int i =0;i<nums.length;i++){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            return gcd(min, max);
    
    
    }

    private int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a= temp;

        }
        return a;
    }
}