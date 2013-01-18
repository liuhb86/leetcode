class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        int result = num[0]+num[1]+num[2];
    	int diff= abs(result-target);
        sort(num.begin(), num.end());
        int size = num.size();
        for(int i=0;i<size-2;++i){
            int a=num[i];
            int j=i+1, k=size-1;
            while(j<k){
                int sum=a+num[j]+num[k];
				if (abs(sum-target)<diff) {
					diff = abs(sum-target);
					result=sum;
				}
                if (sum==target){
					return target;
                } else if (sum<target){
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return result;
    }
};