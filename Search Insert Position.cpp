class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        int* lowerBound = lower_bound(A, A+n,target);
        return lowerBound-A;
    }
};