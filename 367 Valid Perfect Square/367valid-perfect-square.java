class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
    long l = 1, h = num; 

    while (l <= h) {
        long mid = l + (h - l) / 2;
        long sq = mid * mid;
        if (sq == num) {
            return true; 
        } else if (sq < num) {
            l = mid + 1; 
        } else {
            h = mid - 1; 
        }
    }
    return false; 
    }
}