class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) return 0;
        if (m==1 || n==1) return 1;
        vector<vector<int> > count(m+1);
        for(int i=0;i<=m;++i)
        {
            count[i].resize(n+1);
        }
        for (int i=1;i<=m;++i) count[i][1] = 1;
        for (int i=1;i<=n;++i) count[1][i] = 1;
        for (int i=2;i<=m;++i) {
            for (int j=2; j<=n;++j) {
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[m][n];
    }
};
