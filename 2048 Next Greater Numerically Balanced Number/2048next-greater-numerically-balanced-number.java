class Solution {
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) {
                return num;
            }
            num++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        int temp = num;

       
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0) return false; 
            count[digit]++;
            temp /= 10;
        }

       
        for (int d = 1; d <= 9; d++) {
            if (count[d] != 0 && count[d] != d) {
                return false;
            }
        }

        return true;
    }
}
