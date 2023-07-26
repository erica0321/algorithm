import sys

def check(M, N, x, y):
    while x <= M * N:
        if (x - y) % N == 0:
            return x
        x += M
    return -1

T = int(input())

for _ in range(T):  
    M, N, x, y = map(int, sys.stdin.readline().split())
    print(check(M, N, x, y))