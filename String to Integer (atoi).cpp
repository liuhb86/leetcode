class Solution {
public:
    int atoi(const char *str) {
        int MAXT = INT_MAX/10;
        int MINT =-(INT_MIN/10);
                
        bool negative = false;
        int result=0;
        if(str==NULL) return 0;
        while(*str==' ')++str; 
        if (*str=='-') {
            negative = true;
            ++str;
        } else if (*str=='+'){
            ++str;
        }
        int overflowT=(negative)?MINT:MAXT;
        int overflow=(negative)?INT_MIN:INT_MAX;
        while(*str!='\0'){
            char c= *(str++);
            if (c<'0' || c>'9') break;
            if(result>overflowT) return overflow;
            result*=10;
            int digit=c-'0';
            int diff;
    		if(negative) {
				diff=(overflow+result+digit);
				diff=(diff<-10)?10:-diff;
			}
            else diff=overflow-result-digit;
            if (diff<0) return overflow;
            result+=digit;
        }
        if (negative) result=-result;
        return result;
    }
};