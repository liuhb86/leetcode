class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if (matrix.empty() || matrix.back().empty()) return false;
        vector<vector<int> >::iterator lItRow = std::lower_bound(matrix.begin(), matrix.end(), target,comp);
        if (lItRow == matrix.end()) return false;
        return std::binary_search(lItRow->begin(), lItRow->end(), target);
    }
private:
    static bool comp( const vector<int>& a, const int b)
    {
        return a.back() < b;
    }
};
