void reverseString(char* s, int sSize){
    char *i = s;
    char *j = s + sSize - 1;
    char t;
    while (i<j) {
        t = *i; *i=*j; *j=t;
        ++i;--j;
    }
}

