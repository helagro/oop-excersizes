import sys

sys.set_int_max_str_digits(1000000000)

def fibo(n):
    nm2 = nm1 = nm0 = 1

    for _ in range(n-2):
        nm0 = nm2 + nm1
        nm2 = nm1
        nm1 = nm0

    return nm0

arg = sys.argv[1]
res = fibo(int(arg))
print(res)