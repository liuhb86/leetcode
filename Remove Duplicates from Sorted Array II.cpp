class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n==0) return 0;
        int count = 0;
        int* pEnd = A+n;
        int* pNext = A;
        int v = A[0] - 1;
        for (int* p=A;p<pEnd;++p) {
            if (*p!=v) {v= *p; count = 0; *(pNext++) = v; continue;}
            if (count > 0) {continue;}
            count = 1;
            *(pNext++) = v;
        }
        return pNext-A;
    }
    
};
