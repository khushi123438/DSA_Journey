class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;

        for (int i = 0; i <= limit; i++) {
          int left = Math.max(0, n - i - limit);
          int right = Math.min(limit, n - i);

        if (left <= right)
        ans += right - left + 1;
}

return ans;
    }
}