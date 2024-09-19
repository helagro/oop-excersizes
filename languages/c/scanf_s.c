#include <stdio.h>

int main()
{
    char name[5];

    printf("Array of five: ");
    scanf_s("%s", name, 5);

    printf("Entered: %s\n", name);

    return 0;
}