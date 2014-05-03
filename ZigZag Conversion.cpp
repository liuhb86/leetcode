class Solution {
public:
    string convert(string s, int nRows) {
        int len = s.size();
        int groupLen = nRows==1?1:nRows*2-2;
        string result;
        for(int iRow = 0; iRow < nRows; ++iRow)
        {
       	    int iGroup = 0;
       	    bool lbDownward = true;
       	    while(true)
       	    {
       	        int iOffset = (lbDownward)?iRow:groupLen-iRow;
       	        int lPos = iGroup*groupLen + iOffset;
       	        if (lPos >=len ) break;
       	        result.push_back(s.at(lPos));
				if (iRow == 0 || iRow == nRows -1 || !lbDownward)
				{
					++iGroup;
					lbDownward = true;
				}
				else
				{
					lbDownward = false;
				}
			}
        }
		return result;
	}
};