class Solution {
    public boolean isPowerOfFour(int n) {
        // n must be positive
        if (n <= 0) return false;

        // check if n is power of 2 (only one bit set)
        if ((n & (n - 1)) != 0) return false;

        // check if that bit is in even position (mask for even bits)
        return (n & 0x55555555) != 0;
    }
}
