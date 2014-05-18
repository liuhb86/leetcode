#include <iostream>
using namespace std;

class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        for (int i=0;i <n; ++i)
        {
            while(true)
            {
                if (A[i]==i+1) break;
                if (A[i]<=0 || A[i]>n) break;
                int m = A[i];
                if (A[m-1]==m)
                {
                    A[i] = 0;
                }
                else
                {
                    A[i] = A[m-1];
                    A[m-1] = m;
                }
            }
        }
        int missing = 0;
        for (missing=0; missing<n;++missing)
        {
            if (A[missing]!= missing+1)
            {
                break;
            }
        }
        return missing + 1;
    }
    static void main()
    {
        int A[] = {1,1};
        Solution s;
        int r = s.firstMissingPositive(A,2);
        cout<<r<<endl;
    }
};
