class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(rowIndex + 1);
        result[0] = 1;
        int h = (rowIndex)/2;
        unsigned long long b = 1;
        int k = rowIndex;
        for (int i = 1; i<=h; ++i) {
            b = b * k / i;
            --k;
            result[i] = b;
        }
        for (int i = h + 1; i<= rowIndex; ++i) {
            result[i] = result[rowIndex - i];
        }
        return result;
    }
};
