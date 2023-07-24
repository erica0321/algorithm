import sys
n, m = map(int, sys.stdin.readline().split())
li = [i for i in range(n + 1)]

def check(k):
    if li[k] != k:
        li[k] = check(li[k])
    return li[k]

def union(a, b):
    a = check(a)
    b = check(b)
    if a != b:
        li[b] = a

for _ in range(m):
    num, a, b = map(int, sys.stdin.readline().split())
    
    if num == 0:
        union(a, b)
    elif num == 1:
        if check(a) == check(b):
            print('YES')
        else:
            print('NO')