class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1] || colors[n-i-1]!=colors[0])
            return n-1-i;
        }
        return 0;
    }
}