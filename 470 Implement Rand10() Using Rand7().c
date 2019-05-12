// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7

int rand10() {
    int n;
    while (true) {
        n = (rand7() -1 )* 7 + rand7();
        if (n<=10) return n;
    }
}