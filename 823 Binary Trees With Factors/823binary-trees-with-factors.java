import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);

        HashMap<Integer, Long> map = new HashMap<>();
        long count = 0;

        for (int num : arr) {
            map.put(num, 1L);
        }

        for (int i = 0; i < arr.length; i++) {
            long ways = 1;
            for (int j = 0; j < i; j++) {
                  if(arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        ways = (ways + map.get(arr[j]) * map.get(right)) % mod;
                    }
                }
            }
            map.put(arr[i], ways);
            count = (count + ways) % mod;
        }

        return (int) count;
    }
}
