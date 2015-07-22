class Solution {
public:
    int maximumGap(vector<int>& nums) {
        if (nums.size() < 2) return 0;
        auto mm = minmax_element(nums.begin(), nums.end());
        int smallest = *(mm.first);
        int largest = *(mm.second);
        int interval = (largest - smallest) / nums.size() + 1;
        vector<int> lower(nums.size(), 0);
        vector<int> upper(nums.size(), -1);
        for (auto it = nums.begin(); it != nums.end(); ++it) {
            int n = *it;
            int bin = (n-smallest) / interval;
            if (lower[bin] > upper[bin]) {
                lower[bin] = n;
                upper[bin] = n;
            } else if (n < lower[bin]) {
                lower[bin] = n;
            } else if (n > upper[bin]) {
                upper[bin] = n;
            }
        }
        int maxgap = 0;
        int prev = largest;
        for (int i = 0; i< nums.size(); ++i) {
            if (lower[i] > upper[i]) continue;
            if (upper[i] - lower[i] > maxgap) maxgap = upper[i] - lower[i];
            if (lower[i] > prev && lower[i] - prev > maxgap) maxgap = lower[i] - prev;
            prev = upper[i];
        }
        return maxgap;
    }
};
