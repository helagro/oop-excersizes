import sys

def f(n):
    if n < 1: return 1
    return f(n - 1) + f(n - 2)

arg = sys.argv[1]
res = f(int(arg))
print(res)