/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval>::iterator lInsertIt = upper_bound(intervals.begin(), intervals.end(), newInterval, cmp);
        vector<Interval>::iterator lMergeIt = intervals.end();
        if (lInsertIt != intervals.begin()) {
            vector<Interval>::iterator lIt = lInsertIt - 1;
            if (lIt->end >= newInterval.start) lMergeIt = lIt;
        }
        vector<Interval>::iterator lEraseIt = lInsertIt;
        for (;lEraseIt != intervals.end(); ++lEraseIt) {
            if (lEraseIt->start > newInterval.end) break;
            if (lEraseIt->end > newInterval.end) newInterval.end = lEraseIt->end;
        }
        
        if (lMergeIt != intervals.end())
        {
            if (newInterval.end > lMergeIt->end) lMergeIt->end = newInterval.end;
            intervals.erase(lInsertIt, lEraseIt);
        }
        else
        {
            if (lInsertIt == lEraseIt) {
                intervals.insert(lInsertIt, newInterval);
            }
            else {
                *lInsertIt = newInterval;
                intervals.erase(lInsertIt + 1, lEraseIt);
            }
        }
        return intervals;
    }
private:
    static bool cmp(Interval i1, Interval i2) {
        return i1.start < i2.start;
    }
};