class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector<vector<int> > result;
        result.resize(n);
        for (int i=0;i<n;++i) result[i].resize(n);
        int m=n*n;
        int x=0, y=0, dx=1, dy=0;
        for (int i=1;i<=m;++i) {
            result[y][x]=i;
            x+=dx;y+=dy;
            if (x<0||x>=n||y<0||y>=n || result[y][x]!=0) {
                x-=dx;y-=dy;
                int _dy=dy;
                dy = dx;
                dx = - _dy;
                x+=dx;y+=dy;
            }
        }
        return result;
    }
};