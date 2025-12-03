import java.util.HashMap;
import java.util.Map;

class Solution {

    private static class Slope {
        int dx, dy;
        Slope(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slope)) return false;
            Slope other = (Slope) o;
            return dx == other.dx && dy == other.dy;
        }
        @Override
        public int hashCode() {
            return dx * 1000003 ^ dy;
        }
    }

    private static class Mid {
        int mx, my;
        Mid(int mx, int my) {
            this.mx = mx;
            this.my = my;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Mid)) return false;
            Mid other = (Mid) o;
            return mx == other.mx && my == other.my;
        }
        @Override
        public int hashCode() {
            return mx * 1000003 ^ my;
        }
    }

    public int countTrapezoids(int[][] points) {
        int n = points.length;

        Map<Slope, Map<Long, Integer>> slopeLines = new HashMap<>();
        Map<Mid, Map<Slope, Integer>> midSlopes = new HashMap<>();

        // Build all segments
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                Slope s = new Slope(dx, dy);

                int nx = -dy;
                int ny = dx;
                long lineId = (long) nx * x1 + (long) ny * y1;

                slopeLines
                    .computeIfAbsent(s, k -> new HashMap<>())
                    .merge(lineId, 1, Integer::sum);

                int mx = x1 + x2;
                int my = y1 + y2;
                Mid mid = new Mid(mx, my);

                midSlopes
                    .computeIfAbsent(mid, k -> new HashMap<>())
                    .merge(s, 1, Integer::sum);
            }
        }

        long trapezoidsWithParallelSides = 0;

        for (Map<Long, Integer> lines : slopeLines.values()) {
            if (lines.size() < 2) continue;
            long sum = 0;
            long sumSq = 0;
            for (int cnt : lines.values()) {
                sum += cnt;
                sumSq += 1L * cnt * cnt;
            }
            trapezoidsWithParallelSides += (sum * sum - sumSq) / 2;
        }

        long parallelograms = 0;
        for (Map<Slope, Integer> mp : midSlopes.values()) {
            if (mp.size() < 2) continue;
            long sum = 0;
            long sumSq = 0;
            for (int cnt : mp.values()) {
                sum += cnt;
                sumSq += 1L * cnt * cnt;
            }
            parallelograms += (sum * sum - sumSq) / 2;
        }

        long ans = trapezoidsWithParallelSides - parallelograms;
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a == 0 ? 1 : a;
    }
}
