import sys

n, k = map(int, input().split())

need = 0

while bin(n).count('1') > k:
    n += 1
    need += 1

print(need)