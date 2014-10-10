class Solution {
public:
    int singleNumber(int A[], int n) {
        vector<int> num;
        int sign = 0;
        for (int i=0;i<n;++i) {
            unsigned int c;
            if (A[i]<0) {
                sign = (sign+1)%3;
                c=-A[i];
            } else {
                c=A[i];
            }
            int k=0;
            while(c>0) {
                int r = c%3;
                c = c/3;
                if (k>=num.size()) {
                    num.push_back(r);
                } else {
                    num[k] = (num[k] + r) % 3;
                }
                ++k;
            }
        }
        
        unsigned int result = 0;
        for (vector<int>::reverse_iterator it=num.rbegin(); it!=num.rend();++it) {
            result = result*3 + *it;
        }
        if (sign) result = -result;
        return result;
    }
};