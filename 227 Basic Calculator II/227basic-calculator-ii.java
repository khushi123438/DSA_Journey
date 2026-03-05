class Solution {
    public int calculate(String s) {
        int n = s.length();
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {

                if (sign == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                }
                else if (sign == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                }
                else if (sign == '*') {
                    lastNumber = lastNumber * currentNumber;
                }
                else if (sign == '/') {
                    lastNumber = lastNumber / currentNumber;
                }

                sign = c;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
        
    }
}