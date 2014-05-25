class Solution {
public:
    int maxSubArray(int A[], int n) {
        int largest = A[0];
        int sum = A[0];
        for (int i=1;i<n;++i) {
            if (sum > 0)
                sum += A[i];
            else
                sum = A[i]; 
            if (sum > largest) largest = sum;
        }
        return largest;
    }
};