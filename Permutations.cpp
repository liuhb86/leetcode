#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        int size=1;
        for (int i=num.size(); i>1; --i) size*=i;
        vector<vector<int>> result;
        result.reserve(size);
        sort(num.begin(),num.end());
        do
        {
            result.push_back(num);
        } while (next_permutation(num.begin(), num.end()));
        
        return result;
    }
};