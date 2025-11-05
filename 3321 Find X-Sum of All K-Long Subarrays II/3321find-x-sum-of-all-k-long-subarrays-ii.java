import java.util.*;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        // comparator: weakest first -> (freq asc, value asc)
        Comparator<int[]> weakCmp = Comparator
                .comparingInt((int[] p) -> p[0])
                .thenComparingInt(p -> p[1]);

        TreeSet<int[]> topX = new TreeSet<>(weakCmp);  // weakest = first()
        TreeSet<int[]> rest = new TreeSet<>(weakCmp);
        Map<Integer, int[]> nodeMap = new HashMap<>();

        final long[] sumTop = new long[1];
        List<Long> result = new ArrayList<>();

        class Helper {
            void rebalance() {
                // promote strongest from rest (rest.last()) while topX has space
                while (topX.size() < x && !rest.isEmpty()) {
                    int[] p = rest.pollLast();
                    topX.add(p);
                    sumTop[0] += 1L * p[0] * p[1];
                }
                // demote weakest from topX if too many
                while (topX.size() > x) {
                    int[] p = topX.pollFirst();
                    sumTop[0] -= 1L * p[0] * p[1];
                    rest.add(p);
                }
                // fix cross-ordering: if weakest(topX) is weaker than strongest(rest), swap
                while (!topX.isEmpty() && !rest.isEmpty()) {
                    int[] weakestTop = topX.first();
                    int[] strongestRest = rest.last();
                    // if weakestTop < strongestRest, we should swap
                    if (weakCmp.compare(weakestTop, strongestRest) < 0) {
                        topX.remove(weakestTop);
                        rest.remove(strongestRest);
                        topX.add(strongestRest);
                        rest.add(weakestTop);
                        sumTop[0] += 1L * strongestRest[0] * strongestRest[1]
                                    - 1L * weakestTop[0] * weakestTop[1];
                    } else break;
                }
            }
        }

        Helper helper = new Helper();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int oldFreq = freq.getOrDefault(val, 0);
            int newFreq = oldFreq + 1;
            freq.put(val, newFreq);

            // If present, remove old node and adjust sum if it was in topX
            if (oldFreq > 0) {
                int[] oldNode = nodeMap.get(val);
                boolean wasInTop = topX.contains(oldNode);
                // remove from both (one will succeed)
                topX.remove(oldNode);
                rest.remove(oldNode);
                if (wasInTop) sumTop[0] -= 1L * oldNode[0] * oldNode[1];
            }

            // insert new node
            int[] newNode = new int[]{newFreq, val};
            nodeMap.put(val, newNode);

            if (topX.size() < x) {
                // space in topX -> insert here
                topX.add(newNode);
                sumTop[0] += 1L * newFreq * val;
            } else {
                // compare with weakest in topX
                if (!topX.isEmpty() && weakCmp.compare(newNode, topX.first()) > 0) {
                    // newNode stronger than weakest in topX -> put into topX
                    topX.add(newNode);
                    sumTop[0] += 1L * newFreq * val;
                } else {
                    rest.add(newNode);
                }
            }

            helper.rebalance();

            if (i >= k - 1) {
                // record answer
                result.add(sumTop[0]);

                // slide: remove outgoing element
                int outVal = nums[i - k + 1];
                int curFreq = freq.get(outVal);
                int[] node = nodeMap.get(outVal);

                boolean wasInTopOut = topX.contains(node);
                topX.remove(node);
                rest.remove(node);
                if (wasInTopOut) sumTop[0] -= 1L * node[0] * node[1];

                if (curFreq == 1) {
                    freq.remove(outVal);
                    nodeMap.remove(outVal);
                } else {
                    int[] newNode2 = new int[]{curFreq - 1, outVal};
                    freq.put(outVal, curFreq - 1);
                    nodeMap.put(outVal, newNode2);

                    if (topX.size() < x) {
                        topX.add(newNode2);
                        sumTop[0] += 1L * (curFreq - 1) * outVal;
                    } else {
                        if (!topX.isEmpty() && weakCmp.compare(newNode2, topX.first()) > 0) {
                            topX.add(newNode2);
                            sumTop[0] += 1L * (curFreq - 1) * outVal;
                        } else {
                            rest.add(newNode2);
                        }
                    }
                }

                helper.rebalance();
            }
        }

        long[] ans = new long[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
