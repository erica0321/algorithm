import sys
from collections import defaultdict

def find(n):
    if seq[n] != 0:
        return seq[n]

    seq[n] = find(n // p) + find(n // q)
    return seq[n]

n, p, q = map(int, sys.stdin.readline().split())

seq = defaultdict(int)
seq[0] = 1

print(find(n))
