class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty() || matrix.back().empty()) return false;
        int m = matrix.size(), n = matrix.back().size();
        int i=0, j=n-1;
        while(i>=0 && i<m && j>=0 && j<n) {
            if (matrix[i][j]==target) return true;
            if (matrix[i][j]>target) --j;
            else ++i;
        }
        return false;
    }
};
