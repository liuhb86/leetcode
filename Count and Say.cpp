#include <string>
#include <vector>
#include <cstring>
#include <iostream>
using namespace std;

class Solution {
	static vector<char*> mCache;
	static vector<int> mLenCache;
	static vector<int> mDigitCache;
public:
    string countAndSay(int n) {
        if (n<=0) return "";
		buildCache(n);
		return mCache[n];
    }

	void buildCache(int n)
	{
		if (n < mCache.size()) return;
		mCache.reserve(n+1);
		mLenCache.reserve(n+1);
		if (mCache.empty())
		{
			char* newValue;
			newValue = new char[1];
			*newValue = 0;
			mCache.push_back(newValue);
			mLenCache.push_back(0);

			newValue = new char[2];
			strcpy(newValue, "1");
			mCache.push_back(newValue);
			mLenCache.push_back(1);
		}

		for (int i = mCache.size(); i<=n; ++i)
		{
			char* strLast = mCache[i-1];
			int lenLast = mLenCache[i-1];
			char* strNew = new char[lenLast * 2 +1];
			char* pLast = strLast;
			char* pNew = strNew;
			int count = 0;
			while(*pLast != 0)
			{
				char c = *pLast;
				count = 1;
				while(*(++pLast)==c) ++count;
				if (count<10)
				{
					*(pNew++) = '0'+count;
				}
				else
				{
					mDigitCache.clear();
					while(count>0){
						mDigitCache.push_back(count%10);
						count/=10;
					}
					for(vector<int>::reverse_iterator rit= mDigitCache.rbegin(); rit!= mDigitCache.rend(); ++rit)
					{
						*(pNew++) = *rit;
					}
				}
				*(pNew++) = c;
			}
			*pNew = 0;
			mCache.push_back(strNew);
			mLenCache.push_back(pNew-strNew);
		}
	}
	static void main()
	{
        Solution s;
        cout<<s.countAndSay(10);
	}
};
vector<char*> Solution::mCache;
vector<int> Solution::mLenCache;
vector<int> Solution::mDigitCache;