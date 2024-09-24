
def trips(n):
    if n >= 2: return trips(n - 1) + trips(n - 2) 
    return 1

res = trips(1)
print(res)