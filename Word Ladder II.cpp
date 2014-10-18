class Solution {
public:
	vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
		unordered_map<string, vector<string*> > prev;
		int len = ladderLength(start, end, dict, prev);
		
		vector<vector<string> > result;
		vector<string*> path;
		setResult(start, end, prev, path, result);
		return result;
	}
	
	void setResult(string& start, string& end, unordered_map<string, vector<string*> >& prev, vector<string*> path, 
	   vector<vector <string> >& result) {
		if (start==end) {
		    result.push_back(vector<string>());
		    result.back().push_back(start);
			for(vector<string*>::reverse_iterator it = path.rbegin(); it!=path.rend();++it) {
			    result.back().push_back(**it);
			}
			return;
		}
		
		vector<string*> pred = prev[end];
		
		path.push_back(&end);
		for (vector<string*>::iterator it = pred.begin(); it != pred.end(); ++it) {
			setResult(start, **it, prev, path, result);
		}
		path.pop_back();
	}
	
	int ladderLength(string& start, string& end, unordered_set<string>& dict, 
	   unordered_map<string, vector<string*> >& prev) {
		
		unordered_set<string> visited;
	
		set<string*> s1;
		set<string*> s2;
		set<string*>* pCur = &s1;
		set<string*>* pNext = &s2;
		pCur->insert(&start);
		
		int length = 0;
		bool found = false;
		
		while(!pCur->empty()) {
			++length;
			for (set<string*>::iterator it = pCur->begin(); it!= pCur->end(); ++it) {
				visited.insert(**it);
			}
			for (set<string*>::iterator it = pCur->begin(); it!= pCur->end(); ++it) {
			    string& str = **it;
				if (str==end) {
				    return length;
				}
				
			    string s(str);
			    for(int i=0;i<s.size();++i) {
			        int originChar = s[i];
			        for (int c='a'; c<='z'; ++c) {
			            if (c==originChar) continue;
			            s[i]=c;
			            unordered_set<string>::iterator r = dict.find(s);
			            if (r!=dict.end()) {
			                if (visited.find(*r)!=visited.end()) continue;
			                pNext->insert(const_cast<string*>(&*r));
			                prev[s].push_back(*it);
			            }
			        }
			        s[i] = originChar;
			    }
			}
			
			swap(pCur, pNext);
			pNext->clear();
		}
		return -1;
	}
	
	static void main() {
		string start("a");
		string end("c");
		const char* p[] = {"a", "b","c"};
		unordered_set<string> dict;
		for (int i=0; i< 3; ++i) {
			dict.insert(p[i]);
		}
		
		Solution s;
		s.findLadders(start, end, dict);
	}
};