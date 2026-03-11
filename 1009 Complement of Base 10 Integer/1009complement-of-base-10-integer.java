class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        return n ^ ((1 << Integer.toBinaryString(n).length()) - 1);
    }
}