
def product(start, stop, fun):
    res = 1

    for i in range(start, stop +1):
        res *= fun(i)
        
    return res

res = product(1, 10, lambda x: x * x - 19)
print(res)