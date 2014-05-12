#include <vector>
#include <deque>
#include <iostream>
#include <set>
using namespace std;

class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        vector<vector<int> > result;
        set<int> candidateSet;
        for (int i=0;i<candidates.size();++i)
        {
            candidateSet.insert(candidates[i]);
        }
        distinct.clear();
        for (set<int>::iterator it = candidateSet.begin(); it!= candidateSet.end(); ++it)
        {
            distinct.push_back(*it);
        }
        mResult.clear();
        plan.resize(distinct.size());
        solve(distinct.size()-1, target);
        result.resize(mResult.size());
        int iResult = 0;
        for (deque<vector<int> >::iterator it = mResult.begin(); it!=mResult.end(); ++it)
        {
            result[iResult++].swap(*it);
        }
        return result;
    }
private:
    void solve(int maxVal, int target)
    {
        int num = distinct[maxVal];
        if (maxVal == 0)
        {
            if (target % num == 0)
            {
                plan[maxVal] = target/num;
                mResult.push_back(vector<int>());
                for(int i=0;i < distinct.size(); ++i)
                {
                    for (int j=0; j<plan[i]; ++j)
                    {
                        mResult.back().push_back(distinct[i]);
                    }
                }
            }
            return;
        }
        plan[maxVal] = 0;
        while (target >=0)
        {
            solve(maxVal-1, target);
            ++(plan[maxVal]);
            target-=num;
        }
    }

    vector<int> plan;
    deque<vector<int> > mResult;
    vector<int> distinct;
public:
    static void main()
    {
        int candidates[] = {1};
        int target = 1;
        vector<int> lvCandidates(candidates, candidates + 1);
        Solution s;
        vector<vector<int> > result = s.combinationSum(lvCandidates, target);
        for (int i=0;i<result.size();++i)
        {
            for (int j=0;j <result[i].size();++j)
            {
                cout<<result[i][j]<<' ';
            }
            cout<<endl;
        }
    }
};
