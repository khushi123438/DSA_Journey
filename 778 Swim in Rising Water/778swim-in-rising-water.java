class Solution {
    public int swimInWater(int[][] grid) {
         int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int res = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elev = curr[0], i = curr[1], j = curr[2];
            res = Math.max(res, elev);  
            if(i == N-1 && j == N-1) return res;
            if(visited[i][j]) continue;
            visited[i][j] = true;

            for(int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visited[ni][nj]) {
                    pq.offer(new int[]{grid[ni][nj], ni, nj});
                }
            }
        }
        return -1;
    }
}