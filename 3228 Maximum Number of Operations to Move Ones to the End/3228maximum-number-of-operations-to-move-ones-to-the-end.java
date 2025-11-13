class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int one = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                if (i + 1 == n || s.charAt(i + 1) == '1') {
                    count += one;
                }
            }
        }

        return count;
    }
}
