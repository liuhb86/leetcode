char * pushDominoes(char * dominoes){
    char* pushRight = NULL;
    for (char* p = dominoes; *p; ++p) {
        switch(*p) {
            case 'R':
                pushRight = p;
                break;
            case '.':
                if (pushRight) *p = 'R';
                break;
            default:
                if (pushRight) {
                    int len = p - pushRight -1;
                    if (len % 2 == 1) pushRight[len / 2 + 1] = '.';
                    memset(pushRight + (len +1)/ 2 + 1, 'L', len/2);
                    pushRight = NULL;
                } else {
                    for (char* q = p-1; q>=dominoes && *q=='.'; --q) *q = 'L';
                }
        }
    }
    return dominoes;
}

