class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double maxY = 0;

      
        for (int[] sq : squares) {
            totalArea += (double) sq[2] * sq[2];
            maxY = Math.max(maxY, sq[1] + sq[2]);
        }

        double half = totalArea / 2.0;
        double low = 0, high = maxY;

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] sq : squares) {
                int y = sq[1];
                int l = sq[2];

                if (mid > y) {
                    areaBelow += l * Math.min(mid - y, l);
                }
            }

            if (areaBelow < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }
}
