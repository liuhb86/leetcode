class Solution {

public:
    string intToRoman(int num) {
        char unit[5]="IXCM";
        char five[5]="VLD";
        int power=1000;
		string result;
		for(int d=3;d>=0;--d){
			int digit = num/power;
			num=num%power;
			power/=10;
			if(digit==0) continue;
			if(d==3 || digit<4) {
				result.append(digit,unit[d]);
			} else if (digit==4){
				result.append(1,unit[d]).append(1,five[d]);
			} else if (digit<9) {
				result.append(1,five[d]).append(digit-5,unit[d]);
			} else {//digit==9
				result.append(1,unit[d]).append(1,unit[d+1]);
			}
		}
		return result;
    }
};