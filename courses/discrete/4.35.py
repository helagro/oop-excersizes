def gcd(a, b):
    if a == b: return a
    elif a < b: return gcd(b,a)
    return gcd(a - b, b)

res = gcd(10, 26)
print(res)