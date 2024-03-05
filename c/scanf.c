#include <stdio.h>

int main()
{
    char name[5];

    printf("Array of five: ");
    scanf("%4s", name);

    printf("Entered: %s\n", name);

    return 0;
}