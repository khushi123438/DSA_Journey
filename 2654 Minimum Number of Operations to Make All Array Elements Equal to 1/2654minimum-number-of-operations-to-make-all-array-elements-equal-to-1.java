class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int overallGcd = nums[0];

        
        for (int i = 1; i < n; i++) {
            overallGcd = gcd(overallGcd, nums[i]);
        }
        if (overallGcd != 1) return -1;

      
        int countOne = 0;
        for (int x : nums) if (x == 1) countOne++;
        if (countOne > 0) return n - countOne;

      
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; 
                }
            }
        }

        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
