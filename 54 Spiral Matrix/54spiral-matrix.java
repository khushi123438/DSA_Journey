import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int SR = 0, ER = matrix.length - 1;
        int SC = 0, EC = matrix[0].length - 1;

        while (SR <= ER && SC <= EC) {
            // Top row
            for (int j = SC; j <= EC; j++) {
                result.add(matrix[SR][j]);
            }

            // Right column
            for (int i = SR + 1; i <= ER; i++) {
                result.add(matrix[i][EC]);
            }

            // Bottom row
            if (SR < ER) {
                for (int j = EC - 1; j >= SC; j--) {
                    result.add(matrix[ER][j]);
                }
            }

            // Left column
            if (SC < EC) {
                for (int i = ER - 1; i > SR; i--) {
                    result.add(matrix[i][SC]);
                }
            }

            SR++;
            ER--;
            SC++;
            EC--;
        }

        return result;
    }

    // You can remove main method if submitting on online judge like LeetCode
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        // Input matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Call method and print output
        Solution sol = new Solution();
        List<Integer> spiral = sol.spiralOrder(matrix);
        System.out.println("Spiral Order:");
        System.out.println(spiral);
    }
}
