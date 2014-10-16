class Solution {
public:
    int findMin(vector<int> &num) {
        int* begin = num.empty()? NULL : &num[0];
        return findMin(begin, begin + num.size());
    }
    
    int findMin(int* begin, int* end) {
        if (end==begin) return 0;
        if (end==begin+1) return *begin;
        int* mid = begin + (end-begin)/2;
        bool asc1 = *begin <= *(mid-1);
        bool asc2 = *mid <= *(end-1);
        if (asc1&&asc2) return min(*begin, *mid);
        else if (asc1) return findMin(mid,end);
        else return findMin(begin, mid);
    }
};