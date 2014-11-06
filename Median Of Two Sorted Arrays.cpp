class Solution {
public:
    int findK(int*A, int m, int*B, int n, int k) {
        if (m==0) return B[k];
        if (n==0) return A[k];
        if (k==0) return min(A[0],B[0]);
        int i=k/2;
        int j=k-i-1;
        int a= i<m ? A[i] : max(A[m-1], B[n-1]);
        int b= j<n ? B[j] : max(A[m-1], B[n-1]);
        if (a==b) return a;
        if (a<b) {
            return findK(A+i+1, m-i-1, B, n, k-i-1);
        } else {
            return findK(A,m, B+j+1, n-j-1, k-j-1);
        }
    }
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        if ((m+n)%2==0) {
            return (findK(A, m,B,n, (m+n)/2-1) + findK(A,m,B,n,(m+n)/2))/2.0;
        } else {
            return findK(A, m, B, n, (m+n)/2);
        }
    }
};