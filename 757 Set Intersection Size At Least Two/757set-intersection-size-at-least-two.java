class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
      
        Arrays.sort(intervals, (x, y) -> 
            x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]
        );
        
        int a = -1, b = -1; 
        int count = 0;
        
        for (int[] in : intervals) {
            int l = in[0], r = in[1];
            
            boolean aInside = (a >= l);
            boolean bInside = (b >= l);
            
            if (aInside && bInside) {
                continue;    
            }
            
            if (aInside) {
                count++;
                b = a;
                a = r;
            } else {
                count += 2;
                b = r - 1;
                a = r;
            }
        }
        
        return count;
    }
}
