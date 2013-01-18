class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        vector<vector<int> > result;
        sort(num.begin(), num.end());
        int size = num.size();
		for(int p=0;p<size-3;++p){
			if (p>0 && num[p]==num[p-1]) continue;
			int a=num[p];
			for(int i=p+1;i<size-2;++i){
				if (i>p+1 && num[i]==num[i-1]) continue;
				int b=num[i];
				int j=i+1, k=size-1;
				while(j<k){
					int sum=a+b+num[j]+num[k]-target;
					if (sum==0){
						if(result.empty()|| 
						  !(a==result.back()[0] && b==result.back()[1] && num[j]==result.back()[2])){
							result.push_back(vector<int>());
							result.back().push_back(a);
							result.back().push_back(b);
							result.back().push_back(num[j]);
							result.back().push_back(num[k]);
						}
						++j;
					} else if (sum<0){
						++j;
					} else {
						--k;
					}
				}
			}
		}
        return result;
    }
};