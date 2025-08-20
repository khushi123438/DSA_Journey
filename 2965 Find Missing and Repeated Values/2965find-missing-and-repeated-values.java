class Solution {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;
        
        long expectedSum = (long) N * (N + 1) / 2;
        
        boolean[] seen = new boolean[N + 1]; 
        int repeated = -1;
        long actualSum = 0;
        
        for (int[] row : grid) {
            for (int num : row) {
                actualSum += num;
                if (seen[num]) {
                    repeated = num;  
                }
                seen[num] = true;
            }
        }
        
        int missing = (int)(expectedSum - (actualSum - repeated));
        
        return new int[]{repeated, missing};
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int grid[][]= new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]= sc.nextInt();
            }
        }
        findMissingAndRepeatedValues(grid);

    }
}
