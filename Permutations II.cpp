#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        vector<vector<int> > result;
        deque<vector<int> > resultInternal;
        
        sort(num.begin(), num.end());
        do
        {
            resultInternal.push_back(num);
        } while (next_permutation(num.begin(), num.end()));
        
        result.resize(resultInternal.size());
        
        int i=0;
        for(deque<vector<int> >::iterator it = resultInternal.begin(); it!=resultInternal.end(); ++it)
        {
            it->swap(result[i++]);
        }
        
        return result;
    }
};