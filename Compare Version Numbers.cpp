class Solution {
public:
    int compareVersion(string version1, string version2) {
        vector<int> v1 = parseVersion(version1);
        vector<int> v2 = parseVersion(version2);
        for (size_t i = 0; i < v1.size(); ++i) {
            if (v2.size() <= i) return v1[i] == 0 ? 0 : 1;
            if (v1[i] < v2[i]) return -1;
            if (v1[i] > v2[i]) return 1;
        }
        if (v2.size() == v1.size() || v2[v1.size()] == 0) return 0;
        return -1;
    }
    
    vector<int> parseVersion(string version) {
        vector<int> result;
        istringstream iss(version);
        while(iss)
        {
            string s;
            getline(iss, s, '.');
            if (!iss) break;
            istringstream niss(s);
            int num;
            niss>>num;
            result.push_back(num);
        }
        return result;
    }
};
