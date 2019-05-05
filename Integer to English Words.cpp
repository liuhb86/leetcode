class Solution {
public:
    string numberToWords(int num) {
        int p = 1E9;
        if (num>=p) { return combine(num, p, "Billion"); }
        p/=1000;
        if (num>=p) { return combine(num, p, "Million"); }
        p=1000;
        if (num>=p) { return combine(num, p, "Thousand"); }
        p=100;
        if (num>=p) { return combine(num, p, "Hundred"); }
        const char* decades[] = {"Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty"};
        for (int i=90, j=0; i>=20; i-=10,++j) {
            if (num==i) return decades[j];
            if (num>i) return decades[j]+string(" ")+numberToWords(num-i);
        }
        const char* teens[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return teens[num];
    }
    string combine(int num, int p, const char* s) {
        return numberToWords(num/p) + " " + s
                + ((num%p==0) ? "" : (" " + numberToWords(num%p)));
    } 
};
