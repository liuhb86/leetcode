class Solution {
public:
    string convert(string s, int nRows) {
        int* charCount = new int[nRows];
        int len = s.size();
        int groupLen = nRows==1?1:nRows*2-2;
        int nGroup = len/groupLen;
        int remain = len%groupLen;
        charCount[0]=charCount[nRows-1]= nGroup;
        for(int i=1;i<nRows-1;++i) charCount[i]=nGroup*2;
        for(int i=0;remain>0 && i<nRows;++i,--remain) ++charCount[i];
        for(int i=nRows-2;remain>0&&i>=0; --i,--remain) ++charCount[i];
        for(int i=nRows-1;i>0;i--) charCount[i]=charCount[i-1];
        charCount[0]=0;
        for(int i=1;i<nRows;++i) charCount[i]=charCount[i-1]+charCount[i];
        
        string result;
        int cGroup=0, cOffset=0,cStep=1,cRow=0,cCol=0;
        for(int i=0;i<len;++i){
            result.push_back(s.at(charCount[cRow]+cCol));
            ++cOffset;
            cRow+=cStep;
            if (cOffset==1){
                cCol=cGroup*2;
            } else if (cOffset==nRows-1) {
                cCol=cGroup;
            }else if (cOffset==nRows){
                cStep = -1;
                cCol=cGroup*2+1;
                cRow = nRows-2;
            } else if (cOffset==groupLen) {
                ++cGroup;
                cOffset=0;
                cStep=1;
                cRow=0;
                cCol=cGroup;
            }
        }
        delete[] charCount;
        return result;
    }
};