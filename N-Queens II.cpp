#include <vector>
#include <deque>
#include <string>
using namespace std;

class Solution {
public:
    int totalNQueens(int n) {
        this->n = n;
        nResult = 0;
        col.clear();
        left.clear();
        right.clear();
        col.resize(n);
        left.resize(2*n);
        right.resize(2*n);
        solve(0);
        return nResult;
    }
private:
    void solve(int i) {
        if (i==n)
        {
            ++nResult;
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
            solve(i+1);
            col[j] = left[posLeft] = right[posRight] = 0;
        }
    }
    int n;
    vector<char> col;
    vector<char> left;
    vector<char> right;
    int nResult;
};
