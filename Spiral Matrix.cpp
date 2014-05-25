#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int> result;
        int m = matrix.size();
        if (m == 0) return result;
        int n = matrix[0].size();
        int lSize = m * n;
        result.reserve(lSize);

        int bound[4] = {0,n-1,m-1, 0};
        int dBound[4] = {1,-1,-1,1};
        int di = 0;
        int dj = 1;
        int curBound = 0;
        int nextBound = 1;
        int i = 0;
        int j = 0;
        int* b = &j;
        for (int k=0; k<lSize; ++k)
        {
            // cout<<k<<' '<<i<<' '<<j<<endl;
            result.push_back(matrix[i][j]);
            if (*b==bound[nextBound])
            {
                bound[curBound] += dBound[curBound];
                curBound = nextBound;
                nextBound = (nextBound + 1)% 4;
                b = (b==&i) ? &j : &i;
                int t = dj;
                dj = -di;
                di = t;
            }
            i += di;
            j += dj;
        }
        return result;
    }
    static void main() {
        int arr[4][4] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        vector<vector<int> > matrix(4);
        for (int i=0;i<4;++i) {
            matrix[i].resize(4);
            for (int j=0;j<4;++j) {
                matrix[i][j] = arr[i][j];
            }
        }
        Solution s;
        s.spiralOrder(matrix);
    }
};
