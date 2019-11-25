class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        vector<vector<int>> result(2);
        result[0].resize(colsum.size());
        result[1].resize(colsum.size());
        for (int i = 0; i < colsum.size(); ++i) {
            int c = colsum[i];
            if (c==2) {
                result[0][i] = 1;
                result[1][i] = 1;
                --upper; --lower;
            } else if (c==1) {
                if (upper > lower) {
                    result[0][i] = 1;
                    upper -= 1;
                } else {
                    result[1][i] = 1;
                    lower -= 1;
                }
            } 
            if (upper < 0 || lower < 0) return vector<vector<int>>();
        }
        if (upper != 0 || lower != 0) return vector<vector<int>>();
        return result;
    }
};