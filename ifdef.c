#include <stdio.h>

#define RELEASE

#ifdef RELEASE
void mlog(char *msg) {}
#elif defined DEBUG
void mlog(char *msg) { printf("%s", msg); }
#else
void mlog(char *msg) { printf("INVALID BUILD MODE DETECTED!!"); }
#endif

int main()
{
    mlog("Hello World");
    return 0;
}
