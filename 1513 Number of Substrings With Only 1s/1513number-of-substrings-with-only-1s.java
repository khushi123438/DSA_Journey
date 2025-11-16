class Solution {
    public int numSub(String s) {
        int MOD = 1_000_000_007;
        long total = 0;     
        int countOnes = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOnes++;
                total = (total + countOnes) % MOD;
            } else {
                countOnes = 0;
            }
        }

        return (int) total;
    }
}