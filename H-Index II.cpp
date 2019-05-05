class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        if (n==0 || citations.back()==0) return 0;
        int begin = 1;
        int end = n;
        while(begin < end) {
            int middle = begin + (end - begin) / 2 + 1;
            int k = n - middle;
            if (citations[k]>=middle)
                begin = middle;
            else
                end = middle - 1;
        }
        return begin;
    }
};
