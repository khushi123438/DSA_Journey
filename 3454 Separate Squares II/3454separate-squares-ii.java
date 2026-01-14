import java.util.*;

class Solution {

    static class Event {
        double y;
        int type;
        double x1, x2;

        Event(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        double[] length;
        double[] xs;

        SegmentTree(double[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            length = new double[n * 4];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        double totalLength() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        Set<Double> xSet = new HashSet<>();

        for (int[] s : squares) {
            double x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
            xSet.add(x);
            xSet.add(x + l);
        }

        double[] xs = xSet.stream().sorted().mapToDouble(Double::doubleValue).toArray();
        Map<Double, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        events.sort(Comparator.comparingDouble(e -> e.y));
        SegmentTree st = new SegmentTree(xs);

      
        double totalArea = 0;
        double prevY = events.get(0).y;

        for (Event e : events) {
            double curY = e.y;
            totalArea += st.totalLength() * (curY - prevY);
            st.update(xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = curY;
        }

        double half = totalArea / 2.0;

        st = new SegmentTree(xs);
        double area = 0;
        prevY = events.get(0).y;

        for (Event e : events) {
            double curY = e.y;
            double height = curY - prevY;
            double width = st.totalLength();

            if (area + width * height >= half) {
                return prevY + (half - area) / width;
            }

            area += width * height;
            st.update(xIndex.get(e.x1), xIndex.get(e.x2), e.type);
            prevY = curY;
        }

        return prevY;
    }
}
