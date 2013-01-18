struct Number {
    Number(int number, int index){
        this->number = number;
        this->index = index;
    }
    int number;
    int index;
    bool operator < (const Number& that) const{
        return this->number<that.number;
    }
};
class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> result;
        vector<Number> sorted;
        for(int i=0;i<numbers.size();++i){
            sorted.push_back(Number(numbers[i],i+1));
        }
        sort(sorted.begin(), sorted.end());
        for(int i=0,j = sorted.size()-1; i<j;){
            int sum = sorted[i].number+sorted[j].number;
            if(sum==target){
                if(sorted[i].index<sorted[j].index){
                    result.push_back(sorted[i].index);
                    result.push_back(sorted[j].index);
                } else {
                    result.push_back(sorted[j].index);
                    result.push_back(sorted[i].index);
                }
                break;
            } else if (sum<target) {
                ++i;
            } else {
                --j;
            }
        }
        return result;
    }
};