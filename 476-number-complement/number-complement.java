class Solution {
    public int findComplement(int num) {
        int mask = 0;
        int temp = num;

        // Create mask with all bits set to 1 for the length of num
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        // XOR with mask flips bits
        return num ^ mask;
    }
}
