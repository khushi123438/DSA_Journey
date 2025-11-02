class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String curr = "";
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            } else if (c == ']') {
                int times = numStack.pop();
                String prev = strStack.pop();
                curr = prev + curr.repeat(times);
            } else {
                curr += c;
            }
        }

        return curr;
    }
}