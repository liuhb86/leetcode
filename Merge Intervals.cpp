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
    vector<Interval> merge(vector<Interval> &intervals) {
        vector<Interval> result;
        if (intervals.size() == 0) return result;
        sort(intervals.begin(), intervals.end(), cmp);
        Interval i = intervals.front();
        for (vector<Interval>::iterator it = intervals.begin() + 1; it!=intervals.end(); ++it) {
            if (it->start > i.end) {
                result.push_back(i);
                i = *it;
            }
            else if (it->end > i.end) {
                i.end = it->end;
            }
        }
        result.push_back(i);
        return result;
    }
private:
    static bool cmp(Interval i1, Interval i2) {
        return i1.start < i2.start;
    }
};