import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>(); // stores indices
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            // Apply discount when current price <= price at stack top
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                prices[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
