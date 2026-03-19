class Solution {
public:
    int numberOfSubmatrices(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int count = 0;

        vector<vector<int>> val(n, vector<int>(m, 0));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') val[i][j] = 1;
                else if (grid[i][j] == 'Y') val[i][j] = -1;
            }
        }

        vector<int> col(m, 0);
        vector<int> colX(m, 0);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                col[j] += val[i][j];
                if (grid[i][j] == 'X') colX[j]++;
            }

            int prefix = 0;
            int prefixX = 0;

            for (int j = 0; j < m; j++) {
                prefix += col[j];
                prefixX += colX[j];

              
                if (prefix == 0 && prefixX > 0) {
                    count++;
                }
            }
        }

        return count;
    }
};