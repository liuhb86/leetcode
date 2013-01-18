class Solution {
public:
    int romanToInt(string s) {
        int value[26] ={0};
        value['I'-'A']=1;
        value['V'-'A']=5;
        value['X'-'A']=10;
        value['L'-'A']=50;
        value['C'-'A']=100;
        value['D'-'A']=500;
        value['M'-'A']=1000;
		int size=s.size();
		int result=0;
		for(int i=0;i<size;++i){
			int index=s.at(i)-'A';
			if (index<0 || index>=26) continue;
		    if (i+1<size){
				int index_next = s.at(i+1)-'A';
				if (index_next>=0 && index_next<26 && value[index_next]>value[index]){
					result-=value[index];
				} else {
					result+=value[index];
				}
			} else {
				result+=value[index];
			}
		}
		return result;
    }
};