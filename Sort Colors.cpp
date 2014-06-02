class Solution {
public:
    void sortColors(int A[], int n) {
        int count[3] ={0};
        for (int i=0;i<n;++i) ++(count[A[i]]);
        int* begin = A;
        for (int i=0;i<3;++i) {
            int* end = begin +count[i];
            std::fill(begin, end, i);
            begin = end;
        }
    }
};
