class Solution {
public:
    struct Range {
        int buy;
        int sell;
        Range(int b, int s):buy(b), sell(s){}
    };
    int maxProfit(vector<int> &prices) {
        return maxProfit(prices, 2);
    }
    
    int maxProfit(vector<int>& prices, int k) {
        vector<Range> ranges;
        Range r(0,0);
	    int nPrices = prices.size();
        for (int i = 0; i<nPrices -1; ++i) {
            if (prices[i + 1] >= prices[i]) {
                r.sell = i + 1;
            } else {
                if (r.sell > r.buy) ranges.push_back(r);
                r.buy = i + 1;
            }
        }
        if (r.sell > r.buy) ranges.push_back(r);
        
        if (ranges.empty()) return 0;
        
        int n = ranges.size();
        
        vector<vector<int> > profit(n);
        vector<vector<int> > lastContIndex(n);
        for (int i=0; i < n; ++i) {
            profit[i].resize(k+1);
            profit[i][0] = 0;
            int p = prices[ranges[i].sell] - prices[ranges[i].buy];
            if (i==0) {
                for (int j=k; j>=1;--j) {
                    profit[i][j] = p;
                }
                continue;
            }
            for (int j=k; j>=1; --j) {
                int p1 = profit[i-1][j];
                int p2 = profit[i-1][j -1] + p;
                int maxp = max(p1,p2);
                for (int r=0; r<i; ++r) {
                    int p3 = (r ==0 ? 0 : profit[r-1][j-1]) + prices[ranges[i].sell] - prices[ranges[r].buy];
                    if (p3 > maxp) maxp = p3;
                }
		        profit[i][j] = maxp;
                
            }
        }
        return profit[n-1][k];
    }
};