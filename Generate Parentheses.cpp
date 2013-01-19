class Solution {
    char* buffer;
    vector<string>* result;
    int n;
    void generate(int k,int left){
        if(k==2*n){
            buffer[k]='\0';
            result->push_back(string(buffer));
            return;
        }
        if(left!=n){
            buffer[k]='(';
            generate(k+1,left+1);
        } 
        if (k!=2*left){
            buffer[k]=')';
            generate(k+1,left);
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        this->n=n;
        buffer = new char[2*n+1];
        vector<string> result;
        this->result=&result;
        generate(0,0);
        delete[] buffer;
        return result;
    }
};