class Solution {
	string* digits;
	vector<string>* result;
	char* buffer;
public:
    vector<string> letterCombinations(string digits) {
		this->digits=&digits;
		vector<string> result;
		this->result=&result;
		buffer=new char[digits.size()+1];
		print(0);
		delete[] buffer;
		return result;
    }
	
	void print(int k){
		static char* letterMap[]={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		static int sizeMap[]={1,0,3,3,3,3,3,4,3,4};
		if (k==digits->size()){
			buffer[k]='\0';
			result->push_back(string(buffer));
			return;
		}
		int digit=digits->at(k)-'0';
		char* letters= letterMap[digit];
		int size=sizeMap[digit];
		for(int i=0;i<size;++i){
			buffer[k]=letters[i];
			print(k+1);
		}
	}
};