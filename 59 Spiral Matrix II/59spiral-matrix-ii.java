import java.util.*;

class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // left to right
            for (int j = left; j <= right; j++) {
                matrix[top][j] = value++;
            }
            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = value++;
                }
                bottom--;
            }

            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] result = generateMatrix(n);

        // Print the result matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
