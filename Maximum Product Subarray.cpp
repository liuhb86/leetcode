class Solution {
public:
    int maxProduct(int A[], int n) {
        if (n<=0) return 0;
        int result = A[0], productMax = A[0], productMin = A[0];
        for (int i=1;i<n;++i) {
            int tProductMax = productMax;
            productMax = max(max(A[i]*tProductMax, A[i]*productMin), A[i]);
            productMin = min(min(A[i]*tProductMax, A[i]*productMin), A[i]);
            result = max(result, productMax);
        }
        return result;
    }
};