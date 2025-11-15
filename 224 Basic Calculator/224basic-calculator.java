class Solution {
    public int calculate(String s) {
        int res = 0, sign = 1, n = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;
                i--;
            } else if(c == '+') {
                sign = 1;
            } else if(c == '-') {
                sign = -1;
            } else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
        }
        return res;
    }
}