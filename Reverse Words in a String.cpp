class Solution {
public:
    void reverseWords(string &s) {
        string t;
        const char* str=s.c_str();
        const char* begin;
        const char* end = str + s.size() -1;
        bool first = true;
        while(end >= str) {
            while (end>=str && *end==' ') --end;
            if (end <str) break;
            begin = end - 1;
            while(begin >=str && *begin!=' ') --begin;
            if (first) {
                first = false;
            } else {
                t.push_back(' ');
            }
            for (const char* p=begin +1; p<=end; ++p) t.push_back(*p);
            end = begin;
        }
        s = t;
    }
};