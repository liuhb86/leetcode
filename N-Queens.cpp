#include <vector>
#include <deque>
#include <string>
using namespace std;

class Solution {
public:
    vector<vector<string> > solveNQueens(int n) {
        this->n = n;
        row.clear();
        col.clear();
        left.clear();
        right.clear();
        row.resize(n);
        col.resize(n);
        left.resize(2*n);
        right.resize(2*n);
        internalResult.clear();
        solve(0);
        vector<vector<string> > result(internalResult.size());
        for (int i=0; i< internalResult.size(); ++i)
        {
            result[i].swap(internalResult[i]);
        }
        return result;
    }
private:
    void solve(int i) {
        if (i==n)
        {
            internalResult.push_back(vector<string>());
            vector<string>& result = internalResult.back();
            result.reserve(n);
            string blank;
            blank.assign(n,'.');
            for (int j = 0;j<n; ++j)
            {
                string t = blank;
                t[row[j]] = 'Q';
                result.push_back(t);
            }
            return;
        }
        for (int j = 0; j<n; ++j)
        {
            if (col[j]) continue;
            int posLeft = i+j;
            if (left[posLeft]) continue;
            int posRight = i-j+n;
            if (right[posRight]) continue;
            col[j] = left[posLeft] = right[posRight] = 1;
            row[i] = j;
            solve(i+1);
            col[j] = left[posLeft] = right[posRight] = 0;
        }
    }
    int n;
    vector<int> row;
    vector<char> col;
    vector<char> left;
    vector<char> right;
    deque<vector<string> > internalResult;
public:
    static void main()
    {
        Solution s;
        s.solveNQueens(2);
    }
};
