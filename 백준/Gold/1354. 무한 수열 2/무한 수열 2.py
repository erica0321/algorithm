import sys
from collections import defaultdict

def find(n):
    if n <= 0:
        return 1
    
    if seq[n] != 0:
        return seq[n]

    seq[n] = find(n // p - x) + find(n // q - y)
    return seq[n]

n, p, q, x, y = map(int, sys.stdin.readline().split())

seq = defaultdict(int)

print(find(n))
