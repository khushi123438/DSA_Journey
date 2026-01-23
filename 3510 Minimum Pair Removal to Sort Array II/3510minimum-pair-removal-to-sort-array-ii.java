import java.util.*;

class Solution {

    static final int N = 100000;
    static boolean[] rmv = new boolean[N];
    static int[] prv = new int[N];
    static int[] nxt = new int[N];

    
    static long pack(long sum, int idx) {
        return (sum << 17) | idx;
    }

    public static int minimumPairRemoval(int[] nums_) {
        int n = nums_.length;

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = nums_[i];

        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;

        Arrays.fill(rmv, false);

        for (int i = 0; i < n; i++) {
            prv[i] = i - 1;
            nxt[i] = (i + 1 < n) ? i + 1 : -1;
        }

        
        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            heap.offer(pack(nums[i] + nums[i + 1], i));
        }

        int bad = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) bad++;
        }

        int op = 0;

        while (bad > 0 && !heap.isEmpty()) {
            long data = heap.poll();

            long sum = data >> 17;
            int i = (int) (data & ((1 << 17) - 1));

            if (rmv[i] || nxt[i] == -1) continue;

            int j = nxt[i];
            if (rmv[j] || nums[i] + nums[j] != sum) continue;

            int pi = prv[i];
            int nj = nxt[j];

            
            if (pi != -1 && nums[pi] > nums[i]) bad--;
            if (nums[i] > nums[j]) bad--;
            if (nj != -1 && nums[j] > nums[nj]) bad--;

            nums[i] = sum;
            rmv[j] = true;

            nxt[i] = nj;
            if (nj != -1) prv[nj] = i;

           
            if (pi != -1 && nums[pi] > nums[i]) bad++;
            if (nj != -1 && nums[i] > nums[nj]) bad++;

            
            if (pi != -1) {
                heap.offer(pack(nums[pi] + nums[i], pi));
            }
            if (nj != -1) {
                heap.offer(pack(nums[i] + nums[nj], i));
            }

            op++;
        }

        return op;
    }
}
