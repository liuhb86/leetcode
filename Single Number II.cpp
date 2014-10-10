class Solution {
public:
    int singleNumber(int A[], int n) {
        int result = 0;
        int mask = 1;
        for (int i=0;i<sizeof(int)*8;++i) {
            int s=0;
            for (int j=0;j<n;++j) {
                if (A[j]&mask) ++s;
            }
            if (s%3) result= result|mask;
            mask<<=1;
        }
        return result;
    }
};