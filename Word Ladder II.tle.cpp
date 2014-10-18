class Solution {
public:
	vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
		vector<vector<string> > result;
		if (start == end) {
			result.push_back(vector<string>());
			result.back().push_back(start);
			return result;
		}
		
		vector<const char*> vDict;
		vDict.reserve(dict.size());
		vector<vector<int> > prev;
		prev.resize(dict.size() + 1);
		for (unordered_set<string>::iterator it = dict.begin(); it!=dict.end(); ++it) {
			vDict.push_back(it->c_str());
		}
		
		int len = ladderLength(start, end, vDict, prev);
		
		deque<vector<int> > ladders;
		vector<int> ladder;
		ladder.reserve(len);
		listLadders(dict.size(), prev, ladders, ladder);
		result.reserve(ladders.size());
		for (deque<vector<int> >::iterator it = ladders.begin(); it!= ladders.end(); ++it) {
			result.push_back(vector<string>());
			result.back().reserve(it->size());
			for (vector<int>::iterator it2 = it->begin(); it2 != it->end(); ++it2) {
				if (*it2 == -1) {
					result.back().push_back(start);
				} else if (*it2 == dict.size()) {
					result.back().push_back(end);
				} else {
					result.back().push_back(vDict[*it2]);
				}
			}
		}
		return result;
	}
	
	void listLadders(int n, vector<vector<int> >& prev, deque<vector<int> >& ladders, vector<int>& ladder) {
		if (n== -1) {
			ladders.push_back(vector<int>());
			ladders.back().reserve(ladder.size() +1);
			ladders.back().push_back(-1);
			for (vector<int>::reverse_iterator it = ladder.rbegin(); it != ladder.rend(); ++it) {
				ladders.back().push_back(*it);
			}
			return;
		}
		
		ladder.push_back(n);
		for (vector<int>::iterator it = prev[n].begin(); it != prev[n].end(); ++it) {
			listLadders(*it, prev, ladders, ladder);
		}
		ladder.pop_back();
	}
	
	int ladderLength(string start, string end, vector<const char*>& dict, vector<vector<int> >& prev) {
		int n = dict.size();
		const char* pStart = start.c_str();
		const char* pEnd = end.c_str();
		int d = diff(pStart, pEnd);
		if (d == 0) {
			return d + 1;
		} else if (d==1) {
			prev[n].push_back(-1);
			return d + 1;
		}
		
		set<int> unvisited;
		for (int i=0; i<n;++i) {
			unvisited.insert(i);
		}
		
		set<int> s1;
		set<int> s2;
		set<int>* pCur = &s1;
		set<int>* pNext = &s2;
		pCur->insert(-1);
		
		int length = 1;
		bool found = false;
		
		while(!pCur->empty()) {
			for (set<int>::iterator it = pCur->begin(); it!= pCur->end(); ++it) {
				int index = *it;
				const char* s = index == -1 ? pStart : dict[index];
				int d = diff(s, pEnd);
				if (d == 1) {
					prev[n].push_back(index);
					found = true;
				}
				
				if (!found) {
					for (set<int>::iterator it2 = unvisited.begin(); it2 != unvisited.end(); ++it2) {
						if (diff(s, dict[*it2]) < 2) {
							pNext->insert(*it2);
							prev[*it2].push_back(index);
						}
					}
				}
			}
			
			++length;
			if (found) {
				return length;
			}
			
			for (set<int>::iterator it = pNext->begin(); it!=pNext->end(); ++it) {
				unvisited.erase(*it);
			}
			
			swap(pCur, pNext);
			pNext->clear();
		}
		return 0;
	}
	
	int diff(const char* s, const char* t) {
		int d = 0;
		while(*s!=0) {
			if (*s!=*t) {
				++d;
				if (d >=2) return d;
			}
			++s;
			++t;
		}
		return d;
	}
	
	static void main() {
		string start("hot");
		string end("dog");
		const char* p[] = {"hot", "dog"};
		unordered_set<string> dict;
		for (int i=0; i< 2; ++i) {
			dict.insert(p[i]);
		}
		
		Solution s;
		s.findLadders(start, end, dict);
	}
};
