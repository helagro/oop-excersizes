#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

void printBinary(unsigned long *num, long places)
{
    printf("0b");

    unsigned long mask = (1l << (places - 1));
    for (long i = 0; i < places; i++)
    {
        printf("%d", (*num & mask) != 0);
        mask >>= 1;
    }

    printf("\n");
}

void setUnset(unsigned long *num, long and, long or, long bit)
{
    *num &= ~(and << (bit - 1));
    *num |= (or << (bit - 1));

    printf("%lu %lu %ld %hu\n", and << (bit - 1), and, bit, *((unsigned short *)num));
}

int main(int argc, char *argv[])
{
    char *end;
    long and = 1, or = 0;
    unsigned char bits = 0;

    if (argc != 4)
    {
        fprintf(stderr, "Invalid input\n");
        return 1;
    }

    if (strcmp(argv[2], "set") == 0)
    {
        or = 1;
    }
    else if (strcmp(argv[2], "unset") == 0)
    {
        and = 1;
    }
    else
    {
        fprintf(stderr, "Invalid input\n");
        return 1;
    }

    long bit = strtol(argv[3], &end, 16);

    unsigned long a = strtoul(argv[1], &end, 10);
    if (*end != '\0')
    {
        fprintf(stderr, "Invalid input\n");
        return 1;
    }

    if (a < pow(sizeof(char), 8))
    {
        unsigned char n;
        sscanf(argv[1], "%hhu", &n);
        setUnset(((unsigned long *)&n), and, or, bit);
        bits = sizeof(char) * 8;
        printf("0X%x === ", n);
        printBinary(((unsigned long *)&n), sizeof(char) * 8);
    }
    else if (a < pow(sizeof(short), 8))
    {
        unsigned short n;
        sscanf(argv[1], "%hu", &n);
        setUnset(((unsigned long *)&n), and, or, bit);
        bits = sizeof(short) * 8;
        printf("0X%x === ", n);
        printBinary(((unsigned long *)&n), sizeof(short) * 8);
    }
    else if (a < pow(sizeof(int), 8))
    {
        unsigned int n;
        sscanf(argv[1], "%u", &n);
        setUnset(((unsigned long *)&n), and, or, bit);
        bits = sizeof(int) * 8;
        printf("0X%x === ", n);
        printBinary(((unsigned long *)&n), sizeof(int) * 8);
    }
    else if (a < pow(sizeof(long), 8))
    {
        unsigned long n;
        sscanf(argv[1], "%lu", &n);
        setUnset(((unsigned long *)&n), and, or, bit);
        bits = sizeof(long) * 8;
        printf("0X%lx === ", n);
        printBinary(((unsigned long *)&n), sizeof(long) * 8);
    }
    else
    {
        fprintf(stderr, "Invalid input\n");
        return 1;
    }
}