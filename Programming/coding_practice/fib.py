fib = [0, 1]
for i in range(1, 8):
    result = fib[i] + fib[i-1]
    fib.append(result)
    pass

req = int(fib[8-1])
nsum = 0
while(req):
    temp = req%10
    nsum += temp
    req = int(req/10)
    pass

print(nsum, fib[8-1])