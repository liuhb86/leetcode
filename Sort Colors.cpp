class Solution {
public:
    void sortColors(int A[], int n) {
        int * r=A;
        int * b=A+n-1;
        for (int* p=A; p<=b;) {
            if (*p==0) {
                if (p!=r) {
                    *p = *r;
                    *r = 0;
                    ++r;
                } else {
                    ++r;
                    ++p;
                }
            } else if (*p==2) {
                if (p!=b) {
                    *p = *b;
                    *b = 2;
                    --b;
                } else {
                    --b;++p;
                }
            } else {
                ++p;
            }
        }
    }
};