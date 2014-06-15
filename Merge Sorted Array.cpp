class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int* p = A + m - 1;
        int* q = B + n -1;
        int* t = A + m + n -1;
        while(p>=A && q>=B) {
            if (*p > *q) {
                *(t--) = *(p--);
            } else {
                *(t--) = *(q--);
            }
        }
        while(q>=B) {
            *(t--) = *(q--);
        }
    }
};