class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int bal = 0;
        int start = 0;
        int n = gas.size();
        int end;
        int delta;
        for (end = 0;end<n;++end) {
            delta = gas[end] - cost[end];
            if (bal+delta <0) break;
            bal = bal + delta;
        }
        if (end==n) return start;
        if (end==n-1) return -1;
        
        for (start=n-1;start >0;--start) {
            bal += gas[start] - cost[start];
            while(bal+delta>=0) {
                bal+=delta;
                ++end;
                if (end==start) return start;
                delta = gas[end]-cost[end];
            }
            if (end==start -1) return -1;
        }
        return -1;
    }
};