import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = A.length;
        int[] ans = new int[n];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
            if (mp.get(A[i]) == 2) {
                curr++;
            }

            mp.put(B[i], mp.getOrDefault(B[i], 0) + 1);
            if (mp.get(B[i]) == 2) {
                curr++;
            }

            ans[i] = curr;
        }

        return ans;
    }
}