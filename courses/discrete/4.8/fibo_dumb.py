import sys

sys.setrecursionlimit(100000)

def fibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibo(n-1) + fibo(n-2)

arg = sys.argv[1]
res = fibo(int(arg))
print(res)