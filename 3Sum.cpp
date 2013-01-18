class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        vector<vector<int> > result;
        sort(num.begin(), num.end());
        int size = num.size();
        for(int i=0;i<size-2;++i){
            if (i>0 && num[i]==num[i-1]) continue;
            int a=num[i];
            int j=i+1, k=size-1;
            while(j<k){
                int sum=a+num[j]+num[k];
                if (sum==0){
                    if(result.empty()|| 
                      !(a==result.back()[0] && num[j]==result.back()[1])){
                        result.push_back(vector<int>());
                        result.back().push_back(a);
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
        return result;
    }
};