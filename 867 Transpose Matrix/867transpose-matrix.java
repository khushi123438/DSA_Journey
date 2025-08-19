class Solution {
    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] result = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int r= sc.nextInt();
        int c=sc.nextInt();
        int matrix[][]= new int[r][c];
       
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] transposed = transpose(matrix);
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[0].length; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }
    }
}