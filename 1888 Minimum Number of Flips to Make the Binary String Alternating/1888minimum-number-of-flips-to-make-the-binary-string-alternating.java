class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int diff1 = 0; 
        int diff2 = 0; 

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < ss.length(); right++) {

            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (ss.charAt(right) != expected1) diff1++;
            if (ss.charAt(right) != expected2) diff2++;

            if (right - left + 1 > n) {

                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (ss.charAt(left) != leftExpected1) diff1--;
                if (ss.charAt(left) != leftExpected2) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}