﻿class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        for (int i=0;i<n;++i) {
            if (A[i]<=0 || A[i]>n || A[i]==A[A[i]-1]) continue;
            swap(A[i],A[A[i]-1]);
            --i;
        }
        for (int i=0;i<n;++i) {
            if (A[i]!=i+1) return i+1;
        }
        return n+1;
    }
};