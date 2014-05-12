class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result(2);
        int* end = A+n;
        int* lowerBound = lower_bound(A, end, target);
        int* upperBound = upper_bound(A, end, target);
        if (lowerBound==upperBound){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        else
        {
            result[0] = lowerBound - A;
            result[1] = upperBound - A - 1;
        }
        return result;
    }
};