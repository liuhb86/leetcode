class Solution {
public:
    int candy(vector<int> &ratings) {
        int n = ratings.size();
        int candy = 0;
        int i=0;
        while(i<n) {
            int start = i;
            ++i;
            while(i<n && ratings[i] >ratings[i-1]) ++i;
            int peak = i-1;
            while(i<n && ratings[i] < ratings[i-1]) ++i;
            int end = i-1;
            int c1 = peak - start;
            int c2 = end - peak;
            candy += (c1-1) * c1 /2 + (c2-1)*c2/2 + max(c1,c2);
            if (i<n &&ratings[i]>ratings[i-1]) --i;
        }
        candy+=n;
        return candy;
    }
};