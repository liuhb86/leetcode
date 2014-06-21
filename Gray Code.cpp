class Solution {
public:
    vector<int> grayCode(int n) {
        int len = 1<<(n);
        vector<int> result(len);
        result[0] = 0;
        result[1] = 1;
        int num = 1;
        int lead = 1;
        int ff = lead - 1;
        for (int i=2; i<len; ++i) {
            if (num == lead) {
                lead <<=1;
                ff = lead - 1;
            }
            num = lead | result[ff - (i&ff)];
            result[i] = num;
        }
        return result;
    }
};