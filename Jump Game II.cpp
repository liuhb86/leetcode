#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int jump(int A[], int n) {
        if (n<=1) return 0;
        vector<int> locations[2];
        vector<bool> visited(n);
        locations[0].reserve(n);
        locations[1].reserve(n);
        locations[0].push_back(0);
        visited[0] = true;
        int workspace = 0;
        int target = n-1;

        for(int minStep = 1;minStep <n; ++minStep)
        {
            vector<int>* lpCur = &locations[workspace];
            vector<int>* lpNext = &locations[1-workspace];
            lpNext->clear();
            for(vector<int>::iterator it=lpCur->begin();it!=lpCur->end(); ++it)
            {
                int loc = *it;
                int furthest = loc + A[loc];
                if (furthest >= target) return minStep;
                for (int j=furthest;j>loc;--j)
                {
                    if (visited[j]) continue;
                    visited[j] = true;
                    lpNext->push_back(j);
                }
            }
            workspace = 1-workspace;
        }
        return n-1;
    }
    static void main()
    {
        int A[]={1,2};
        Solution s;
        cout<<  s.jump(A,2);
    }
};
