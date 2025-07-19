class Solution {
    public boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        return original == reverse;
    }
}

public class Main {
    public static void main(String[] args) {
        int param_1 = 121;

        Solution sol = new Solution();
        boolean ret = sol.isPalindrome(param_1);

        System.out.println(param_1 + " is palindrome? " + ret);
    }
}
