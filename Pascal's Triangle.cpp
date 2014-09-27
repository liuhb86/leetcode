class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int> > result(numRows);
        for (int i= 0; i<numRows; ++i) {
            vector<int>& row = result[i];
            row.resize(i + 1);
            row[0] = 1;
            row[i] = 1;
            for (int j = 1; j < i; ++j) row[j] = result[i-1][j-1] + result[i-1][j];
        }
        return result;
    }
};
