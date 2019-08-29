void reverse(char* s, char* t) {
    t--;
    while (s < t) {
        char c = *s; *s = *t; *t = c;
        s++; t--;
    }
}

void reverseWords(char* s, int sSize){
    if (sSize == 0) return;
    char* p = s;
    char* e = s + sSize;
    while (p < e) {
        char* q = p + 1;
        while (q<e && *q!=' ') q++;
        reverse(p,q);
        p = q + 1;
    }
    reverse(s, e);
}