class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        int m = grid.size();
        if (m<=0) return 0;
        int n = grid.back().size();
        if (n<=0) return 0;
        vector<vector<int> > count(m);
        for(int i=0;i<m;++i)
        {
            count[i].resize(n);
        }
        count[0][0] = grid[0][0];
        for (int i=0;i<m;++i) {
            for (int j=0; j<n;++j) {
                if (i==0 && j==0) continue;
                int c = -1;
                if (i>0) c=count[i-1][j];
                if (j>0 && (c<0 || count[i][j-1]<c)) c=count[i][j-1];
                count[i][j] = c + grid[i][j];
            }
        }
        return count[m-1][n-1];
    }
};
