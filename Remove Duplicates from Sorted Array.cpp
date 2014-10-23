class Solution {
public:
    int removeDuplicates(int A[], int n) {
        int prev;
        int* p=A;
        for (int i=0;i<n;++i)
            if (i==0 ||A[i]!=prev) *(p++)=prev=A[i];
        return p-A;
    }
};