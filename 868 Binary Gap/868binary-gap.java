class Solution {
    public int binaryGap(int n) {
        int lastOne = -1;  
        int maxGap = 0;
        int position = 0; 
        
        while (n > 0) {
            if ((n & 1) == 1) {  
                if (lastOne != -1) {
                    maxGap = Math.max(maxGap, position - lastOne);
                }
                lastOne = position;
            }
            
            n = n >> 1;
            position++;
        }
        
        return maxGap;
    }
}