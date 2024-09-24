
def bin(s, n):
    if n == 0: return s + ''
    return [bin(s + '0', n-1), bin(s + '1', n-1) ]


res = bin('', 2)
print(res)