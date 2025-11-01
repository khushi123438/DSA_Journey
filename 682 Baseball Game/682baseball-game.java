import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int n = operations.length;

        for (int i = 0; i < n; i++) {
            String op = operations[i]; 

            if (op.equals("C")) {
                if (!s.isEmpty())
                    s.pop();
            } 
            else if (op.equals("D")) {
                s.push(2 * s.peek());
            } 
            else if (op.equals("+")) {
                int last = s.pop();
                int newScore = last + s.peek();
                s.push(last);
                s.push(newScore);
            } 
            else {
                s.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : s) {
            sum += score;
        }

        return sum; 
    }
}
