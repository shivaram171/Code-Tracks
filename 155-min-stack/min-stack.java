import java.util.Stack;

class MinStack {

    private Stack<int[]> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        int min;
        if (s.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, s.peek()[1]);
        }
        s.push(new int[]{val, min});
    }

    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }
}
