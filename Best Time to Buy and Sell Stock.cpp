class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int n = prices.size();
        vector<int> delta(n);
        for (int i = 0; i < n - 1; ++i) delta[i] = prices[i+1] - prices[i];
        int maxprofit = 0;
        int profit = 0;
        for (int i=0; i < n-1; ++i) {
            profit += delta[i];
            if (profit < 0) profit = 0;
            if (profit > maxprofit) maxprofit = profit;
        }
        return maxprofit;
    }
};