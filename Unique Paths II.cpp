class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        int m = obstacleGrid.size();
        if (m<=0) return 0;
        int n = obstacleGrid.back().size();
        if (n<=0) return 0;
        if (obstacleGrid[0][0]) return 0;
        vector<vector<int> > count(m);
        for(int i=0;i<m;++i)
        {
            count[i].resize(n);
        }
        count[0][0] = 1;
        for (int i=0;i<m;++i) {
            for (int j=0; j<n;++j) {
                if (i==0 && j==0) continue;
                if (obstacleGrid[i][j]) {
                    count[i][j] = 0;
                    continue;
                }
                int c = 0;
                if (i>0) c+=count[i-1][j];
                if (j>0) c+=count[i][j-1];
                count[i][j] = c;
            }
        }
        return count[m-1][n-1];
    }
};
