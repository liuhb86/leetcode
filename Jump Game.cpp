class Solution {
public:
    bool canJump(int A[], int n) {
        int farthest = 0;
        for (int i=0; i<=farthest; ++i)
        {
            int t = i + A[i];
            if (t>=n-1) return true;
            if (t>farthest) farthest = t;
        }
        return false;
    }
};