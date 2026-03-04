class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int time = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottedThisMinute = false;

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : directions){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr < m && nc < n 
                       && grid[nr][nc] == 1){

                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            if(rottedThisMinute) time++;
        }

        return fresh == 0 ? time : -1;

    }
}