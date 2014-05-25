#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        vector<vector<int> > result;
        if (n<=0) return result;
        
        result.resize(n);
        for (int i=0;i<n;++i) {
            result[i].resize(n);
        }
        
        int m = n;
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
            result[i][j] = k + 1;
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
};
