class Solution {
    public int smallestNumber(int n) {
        int L = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        return (1 << L) - 1;
    }
}