import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = addBoundaries(hFences, m);
        int[] v = addBoundaries(vFences, n);
        
        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(h[j] - h[i]);
            }
        }
        
        long maxSide = -1;
        
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int currentGap = v[j] - v[i];
                if (hGaps.contains(currentGap)) {
                    maxSide = Math.max(maxSide, currentGap);
                }
            }
        }
        
        if (maxSide == -1) {
            return -1;
        }
        
        long mod = 1_000_000_007L;
        return (int) ((maxSide * maxSide) % mod);
    }
    
    private int[] addBoundaries(int[] fences, int boundary) {
        int[] result = new int[fences.length + 2];
        result[0] = 1;
        result[result.length - 1] = boundary;
        System.arraycopy(fences, 0, result, 1, fences.length);
        Arrays.sort(result);
        return result;
    }
}