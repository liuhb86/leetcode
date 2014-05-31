class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        int len = digits.size();
        int k;
        for (k=len-1;k>=0;--k)
        {
            if (digits[k]!=9) break;
        }
        vector<int> result;
        if (k<0)
        {
            result.resize(len+1);
            result[0] = 1;
        }
        else
        {
            result.resize(len);
            for (int i=0;i<k;++i) result[i]=digits[i];
            result[k] = digits[k]+1;
        }
        return result;
    }
};
