class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // use unsigned right shift >>> to handle negative numbers
        while (num != 0 && sb.length() < 8) {
            sb.append(map[num & 15]); // get last 4 bits
            num >>>= 4; // logical shift right by 4 bits
        }

        return sb.reverse().toString();
    }
}
